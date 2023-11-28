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

import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/consultaCrudUsuario")
	@ResponseBody
	public List<Usuario> listaUsuarios(String filtro) {
		List<Usuario> listSalida = service.listaPorNombreUsuarioLike("%" + filtro + "%");
		return listSalida;
	}

	@PostMapping("/registraCrudUsuario")
	@ResponseBody
	public Map<?, ?> registra(Usuario obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		obj.setFechaRegistro(new Date());

		Usuario objSalida = service.insertaActualizaUsuario(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Usuario> lista = service.listaPorNombreUsuarioLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/actualizaCrudUsuario")
	@ResponseBody
	public Map<?, ?> actualiza(Usuario obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Optional<Usuario> optUsuario = service.listaUsuarioPorId(obj.getIdUsuario());

		obj.setFechaRegistro(optUsuario.get().getFechaRegistro());
		
		Usuario objSalida = service.insertaActualizaUsuario(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Usuario> lista = service.listaPorNombreUsuarioLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/eliminaCrudUsurio")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Usuario obj = service.listaUsuarioPorId(id).get();

		Usuario objSalida = service.insertaActualizaUsuario(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Usuario> lista = service.listaPorNombreUsuarioLike("%");
			map.put("lista", lista);
		}
		return map;
	}
}
