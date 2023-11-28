package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		// obj.setEstado(optAlumno.get().getEstado());
		Estado activo = new Estado();
		activo.setIdestado(2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);
		
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
		activo.setIdestado( obj.getEstado().getIdestado() == 2? 1:2);
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

	/*
	 * //
	 * 
	 * @GetMapping("/consultaCrudProovedor/nombre")
	 * 
	 * @ResponseBody public List<Proveedor> listaProveedor(String filtro) {
	 * List<Proveedor> listProveedor = service.listaPorNombreLike("%" + filtro +
	 * "%"); return listProveedor; }
	 * 
	 * @GetMapping("/consultaCrudProovedor/telefono")
	 * 
	 * @ResponseBody public List<Proveedor> listaTelefono(String filtro) {
	 * List<Proveedor> lisTelefono = service.listaPorTelefonoLike("%" + filtro +
	 * "%"); return lisTelefono; }
	 * 
	 * @GetMapping("/consultaCrudProovedor/direccion")
	 * 
	 * @ResponseBody public List<Proveedor> listaDireccion(String filtro) {
	 * List<Proveedor> listDireccion = service.listaPorDireccionLike("%" + filtro +
	 * "%"); return listDireccion; }
	 * 
	 * @GetMapping("/consultaCrudProovedor/correo")
	 * 
	 * @ResponseBody public List<Proveedor> listaCorreo(String filtro) {
	 * List<Proveedor> listCorreo = service.listaPorCorreoLike("%" + filtro + "%");
	 * return listCorreo; }
	 */

}
