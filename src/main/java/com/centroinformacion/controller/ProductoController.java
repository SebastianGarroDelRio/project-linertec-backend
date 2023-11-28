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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Producto;
import com.centroinformacion.service.ProductoService;
import com.centroinformacion.util.AppSettings;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService service;

	@GetMapping("/consultaCrudProducto")
	@ResponseBody
	public List<Producto> lista(String filtro) {
		List<Producto> listSalida = service.listaPorNombreProductoLike("%" + filtro + "%");
		return listSalida;
	}

	@PostMapping("/registraCrudProducto")
	@ResponseBody
	public Map<?, ?> registra(Producto obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		obj.setFechaRegistro(new Date());
		obj.setEstado(AppSettings.ACTIVO);

		Producto objSalida = service.insertaActualizaProducto(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Producto> lista = service.listaPorNombreProductoLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/actualizaCrudProducto")
	@ResponseBody
	public Map<?, ?> actualiza(Producto obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Optional<Producto> optAlumno = service.listaProductoPorId(obj.getIdProducto());
		
		obj.setFechaRegistro(optAlumno.get().getFechaRegistro());
		obj.setEstado(optAlumno.get().getEstado());

		Producto objSalida = service.insertaActualizaProducto(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Producto> lista = service.listaPorNombreProductoLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/eliminaCrudProducto")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Producto obj = service.listaProductoPorId(id).get();
		
		obj.setEstado(obj.getEstado() == 1 ? 0 : 1);

		Producto objSalida = service.insertaActualizaProducto(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Producto> lista = service.listaPorNombreProductoLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	@GetMapping("/obtenerPrecioUnitario")
	@ResponseBody
	public Map<String, Object> obtenerPrecioUnitario(@RequestParam("id") int idProducto) {
	    Map<String, Object> response = new HashMap<>();
	    
	    Optional<Producto> producto = service.listaProductoPorId(idProducto);
	    
	    if (producto.isPresent()) {
	        response.put("precioUnitario", producto.get().getPrecioUnitario());
	        response.put("mensaje", "Precio unitario obtenido correctamente");
	    } else {
	        response.put("mensaje", "Producto no encontrado");
	    }

	    return response;
	}

}
