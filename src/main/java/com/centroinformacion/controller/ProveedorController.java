package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Estado;
import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.service.ProveedorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorService service;

	@GetMapping("/consultaCrudProveedor")
	@ResponseBody
	public List<Proveedor> listaProveedores(String filtro) {
		List<Proveedor> listSalida = service.listaPorNombreLike("%" + filtro + "%");
		return listSalida;
	}

	@PostMapping("/registraCrudProveedor")
	@ResponseBody
	public Map<?, ?> registra(Proveedor obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		obj.setFechaRegistro(new Date());
		Estado activo = new Estado();
		activo.setIdestado(1);
		activo.setDescripcionestado("Activo");
		obj.setEstado(activo);

		
		List<Proveedor> lstNombre = service.listaProveedorPorNombreDiferenteSiMismo(obj.getNombreProveedor(), obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstNombre)) {
			map.put("mensaje", "El Proveedor con el nombre " + obj.getNombreProveedor() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstCorreo = service.listaProveedorPorCorreoDiferenteSiMismo(obj.getCorreo(), obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstCorreo)) {
			map.put("mensaje", "El Proveedor con el correo " + obj.getCorreo() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstTelefono = service.listaProveedorPorTelefonoDiferenteSiMismo(obj.getTelefono(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstTelefono)) {
			map.put("mensaje", "El Proveedor con el número de telefono " + obj.getTelefono() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstDireccion = service.listaProveedorPorDireccionDiferenteSiMismo(obj.getDireccion(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstDireccion)) {
			map.put("mensaje", "El Proveedor con la direccion " + obj.getDireccion() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstTelefonoC = service.listaProveedorPorTelefonoContactoDiferenteSiMismo(obj.getTelefonoContacto(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstTelefonoC)) {
			map.put("mensaje", "El Proveedor con el número de telefono " + obj.getTelefonoContacto() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		
		List<Proveedor> lstNumeroD = service.listaProveedorPorNumeroDocumentoDiferenteSiMismo(obj.getNumeroDocumento(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstNumeroD)) {
			map.put("mensaje", "El Proveedor con el número de documento " + obj.getNumeroDocumento() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}

		Proveedor objSalida = service.insertaActualizaProveedor(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/actualizaCrudProveedor")
	@ResponseBody
	public Map<?, ?> actualiza(Proveedor obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Optional<Proveedor> optAlumno = service.listaProveedorPorId(obj.getIdProveedor());

		obj.setFechaRegistro(optAlumno.get().getFechaRegistro());
		Estado activo = new Estado();
		activo.setIdestado(2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);
		
		List<Proveedor> lstNombre = service.listaProveedorPorNombreDiferenteSiMismoActualiza(obj.getNombreProveedor(), obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstNombre)) {
			map.put("mensaje", "El Proveedor con el nombre " + obj.getNombreProveedor() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstCorreo = service.listaProveedorPorCorreoDiferenteSiMismoActualiza(obj.getCorreo(), obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstCorreo)) {
			map.put("mensaje", "El Proveedor con el correo " + obj.getCorreo() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstTelefono = service.listaProveedorPorTelefonoDiferenteSiMismoActualiza(obj.getTelefono(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstTelefono)) {
			map.put("mensaje", "El Proveedor con el número de telefono " + obj.getTelefono() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstDireccion = service.listaProveedorPorDireccionDiferenteSiMismoActualiza(obj.getDireccion(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstDireccion)) {
			map.put("mensaje", "El Proveedor con la direccion " + obj.getDireccion() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		List<Proveedor> lstTelefonoC = service.listaProveedorPorTelefonoContactoDiferenteSiMismoActualiza(obj.getTelefonoContacto(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstTelefonoC)) {
			map.put("mensaje", "El Proveedor con el número de telefono " + obj.getTelefonoContacto() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}
		
		
		List<Proveedor> lstNumeroD = service.listaProveedorPorNumeroDocumentoDiferenteSiMismoActualiza(obj.getNumeroDocumento(),
				obj.getIdProveedor());
		if (!CollectionUtils.isEmpty(lstNumeroD)) {
			map.put("mensaje", "El Proveedor con el número de documento " + obj.getNumeroDocumento() + " ya existe");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
			return map;
		}

		Proveedor objSalida = service.insertaActualizaProveedor(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/eliminaCrudProveedor")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Proveedor obj = service.listaProveedorPorId(id).get();

		// obj.setEstado(obj.getEstado() == 1 ? 0 : 1);
		Estado activo = new Estado();
		activo.setIdestado(obj.getEstado().getIdestado() == 2 ? 1 : 2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);
		Proveedor objSalida = service.insertaActualizaProveedor(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Proveedor> lista = service.listaPorNombreLike("%");
			map.put("lista", lista);
		}
		return map;
	}

}
