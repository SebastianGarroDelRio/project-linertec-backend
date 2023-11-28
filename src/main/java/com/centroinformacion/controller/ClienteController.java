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

import com.centroinformacion.entity.Cliente;
import com.centroinformacion.entity.Estado;
import com.centroinformacion.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/consultaCrudCliente")
	@ResponseBody
	public List<Cliente> listaClientes(String filtro) {
		List<Cliente> listSalida = service.listaPorNombreClienteLike("%" + filtro + "%");
		return listSalida;
	}

	@PostMapping("/registraCrudCliente")
	@ResponseBody
	public Map<?, ?> registra(Cliente obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		obj.setFechaRegistro(new Date());
		Estado activo = new Estado();
		activo.setIdestado(1);
		activo.setDescripcionestado("Activo");
		obj.setEstado(activo);

		Cliente objSalida = service.insertaActualizaCliente(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en el registro");
		} else {
			map.put("mensaje", "Registro Exitoso");
			List<Cliente> lista = service.listaPorNombreClienteLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/actualizaCrudCliente")
	@ResponseBody
	public Map<?, ?> actualiza(Cliente obj, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Optional<Cliente> optCliente = service.listaClientePorId(obj.getIdCliente());

		obj.setFechaRegistro(optCliente.get().getFechaRegistro());
		Estado activo = new Estado();
		activo.setIdestado(2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);
		
		Cliente objSalida = service.insertaActualizaCliente(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error al actualizar");
		} else {
			map.put("mensaje", "Actualizacion exitosa");
			List<Cliente> lista = service.listaPorNombreClienteLike("%");
			map.put("lista", lista);
		}
		return map;
	}

	@PostMapping("/eliminaCrudCliente")
	@ResponseBody
	public Map<?, ?> elimina(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		Cliente obj = service.listaClientePorId(id).get();

		Estado activo = new Estado();
		activo.setIdestado( obj.getEstado().getIdestado() == 2? 1:2);
		activo.setDescripcionestado("");
		obj.setEstado(activo);
		Cliente objSalida = service.insertaActualizaCliente(obj);
		if (objSalida == null) {
			map.put("mensaje", "Error en actualizar");
		} else {
			List<Cliente> lista = service.listaPorNombreClienteLike("%");
			map.put("lista", lista);
		}
		return map;
	}
}
