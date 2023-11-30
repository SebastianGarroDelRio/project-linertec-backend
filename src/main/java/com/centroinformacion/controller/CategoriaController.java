package com.centroinformacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.entity.Estado;
import com.centroinformacion.service.CategoriaService;

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

		Estado activo = new Estado();
		activo.setIdestado(1);
		activo.setDescripcionestado("Activo");
		obj.setEstado(activo);

		List<Categoria> lstDescripcion = service
				.listaCategoriaPorDescripcionDiferenteSiMismo(obj.getDescripcionCategoria(), obj.getIdCategoria());
		if (!CollectionUtils.isEmpty(lstDescripcion)) {
			map.put("mensaje", "La categoria con la descripcion " + obj.getDescripcionCategoria() + " ya existe");
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
			return map;
		}

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

		Estado activo = new Estado();
		activo.setIdestado(2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);

		List<Categoria> lstDescripcion = service
				.listaCategoriaPorDescripcionDiferenteSiMismo(obj.getDescripcionCategoria(), obj.getIdCategoria());
		if (!CollectionUtils.isEmpty(lstDescripcion)) {
			map.put("mensaje", "La categoria con la descripcion " + obj.getDescripcionCategoria() + " ya existe");
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
			return map;
		}

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

	@DeleteMapping("/eliminaCrudCategoria")
	@ResponseBody
	public Map<?, ?> elimina(@RequestParam int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		boolean eliminacionExitosa = service.eliminaCategoriaPorId(id);
		if (eliminacionExitosa) {
			List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
			map.put("lista", lista);
		} else {
			map.put("mensaje", "Error al eliminar el registro");
		}
		return map;
	}
}
