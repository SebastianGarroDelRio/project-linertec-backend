package com.centroinformacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.service.CategoriaService;
import com.centroinformacion.util.AppSettings;

import jakarta.servlet.http.HttpSession;


@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService service;
 
	@GetMapping("/consultaCrudCategoria")
	@ResponseBody
	public List<Categoria> lista(String filtro) {
		List<Categoria> listSalida = service.listaPorNombreCategoriaLike("%" + filtro + "%");
		return listSalida;
	}
	
	@PostMapping("/registraCrudCategoria")
	@ResponseBody
	public Map<?, ?> registra(Categoria obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		obj.setEstado(AppSettings.ACTIVO);
		
		Categoria objSalida = service.insertaActualizaCategoria(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
		}
		return map;
	}
	
	@PostMapping("/actualizaCrudCategoria")
	@ResponseBody
	public Map<?, ?> actualiza(Categoria obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Optional<Categoria> optCategoria = service.listaCategoriaPorId(obj.getIdCategoria());
		
		obj.setEstado(optCategoria.get().getEstado());
		
		Categoria objSalida = service.insertaActualizaCategoria(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/eliminaCrudCategoria")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Categoria obj = service.listaCategoriaPorId(id).get();
		
		obj.setEstado(obj.getEstado() == 1 ? 0 : 1);

		Categoria objSalida = service.insertaActualizaCategoria(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
		}
		return map;
	}
}
