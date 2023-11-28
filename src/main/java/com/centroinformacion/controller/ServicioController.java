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

import com.centroinformacion.entity.EstadoServicio;
import com.centroinformacion.entity.Servicio;
import com.centroinformacion.service.ServicioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ServicioController {
	
	@Autowired
	private ServicioService service;
	
	@GetMapping("/consultaCrudServicio")
	@ResponseBody
	public List<Servicio> listaServicios(String filtro) {
		List<Servicio> listSalida = service.listaPorNombreServicioLike("%" + filtro + "%");
		return listSalida;
	}

	@PostMapping("/registraCrudServicio")
	@ResponseBody
	public Map<?, ?> registra(Servicio obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		obj.setFechaRegistro(new Date());
		EstadoServicio activo = new EstadoServicio();
		activo.setIdEstadoServicio(1);
		activo.setDescripcionEstadoServicio("Activo");
		obj.setEstadoServicio(activo);

		Servicio objSalida = service.insertaActualizaServicio(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Servicio> lista = service.listaPorNombreServicioLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	@PostMapping("/actualizaCrudServicio")
	@ResponseBody
	public Map<?, ?> actualiza(Servicio obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Optional<Servicio> optServicio = service.listaServicioPorId(obj.getIdServicio());

		obj.setFechaRegistro(optServicio.get().getFechaRegistro());
		EstadoServicio activo = new EstadoServicio();
		activo.setIdEstadoServicio(1);
		activo.setDescripcionEstadoServicio("Activo");
		obj.setEstadoServicio(activo);
		
		Servicio objSalida = service.insertaActualizaServicio(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Servicio> lista = service.listaPorNombreServicioLike("%");
			map.put("lista", lista);
		}
		return map; 
	}
	
	@PostMapping("/eliminaCrudServicio")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Servicio obj = service.listaServicioPorId(id).get();

		EstadoServicio activo = new EstadoServicio();
		activo.setIdEstadoServicio( obj.getEstadoServicio().getIdEstadoServicio() == 2? 1:2);
		activo.setDescripcionEstadoServicio("");
		obj.setEstadoServicio(activo);
		
		Servicio objSalida = service.insertaActualizaServicio(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Servicio> lista = service.listaPorNombreServicioLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	@GetMapping("/obtenerServicioPorId")
	@ResponseBody
	public Map<?, ?> obtenerServicioPorId(@RequestParam int idServicio) {
	    HashMap<String, Object> map = new HashMap<String, Object>();

	    Optional<Servicio> optServicio = service.listaServicioPorId(idServicio);

	    if (optServicio.isPresent()) {
	        Servicio servicio = optServicio.get();
	        
	        String descripcionServicio = servicio.getDescripcionServicio();
	        double costoServicio = servicio.getCostoServicio();
	        int idTipoServicio = servicio.getTipoServicio().getIdTipoServicio();
	        int idEstadoServicio = servicio.getEstadoServicio().getIdEstadoServicio();
	        //int idCliente = servicio.getCliente().getIdCliente();
	        
	        map.put("mensaje", "Obtención exitosa");
	        map.put("descripcionServicio", descripcionServicio);
	        map.put("costoServicio", costoServicio);
	        map.put("idTipoServicio", idTipoServicio);
	        map.put("idEstadoServicio", idEstadoServicio);
	        //map.put("idCliente", idCliente);
	    } else {
	        map.put("mensaje", "Servicio no encontrado");
	    }

	    return map;
	}

}
