package com.centroinformacion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.centroinformacion.entity.DetalleServicio;
import com.centroinformacion.service.DetalleServicioService;


import jakarta.servlet.http.HttpSession;

@Controller
public class DetalleServicioController {
	
	@Autowired
	private DetalleServicioService service;
	
	
	@PostMapping("/registraCrudDetalleServicio")
	@ResponseBody
	public Map<?, ?> registra(DetalleServicio obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		DetalleServicio objSalida = service.insertaActualizaCDetalleServicio(obj);
		
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
		}
		return map;
	}
}
