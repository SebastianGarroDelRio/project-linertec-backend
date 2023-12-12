package com.centroinformacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnlaceController {
	
	@GetMapping("/verLogin")
	public String verLogin() {
		return "intranetLogin";
	}

	@GetMapping("/verIntranetHome")
	public String verIntranetHome() {
		return "intranetHome";
	}

	@GetMapping("/verCrudCategoria")
	public String verCrudCategoria() {
		return "intranetCrudCategoria";
	}

	@GetMapping("/verCrudCliente")
	public String verCrudCliente() {
		return "intranetCrudCliente";
	}

	@GetMapping("/verCrudContrato")
	public String verCrudContrato() {
		return "intranetCrudContrato";
	}

	@GetMapping("/verCrudDetalleServicio")
	public String verCrudDetalleServicio() {
		return "intranetCrudDetalleServicio";
	}

	@GetMapping("/verCrudProducto")
	public String verCrudProducto() {
		return "intranetCrudProducto";
	}

	@GetMapping("/verCrudProveedor")
	public String verCrudProveedor() {
		return "intranetCrudProveedor";
	}

	@GetMapping("/verCrudServicio")
	public String verCrudServicio() {
		return "intranetCrudServicio";
	}

	@GetMapping("/verCrudUsuario")
	public String verCrudUsuario() {
		return "intranetCrudUsuario";
	}

	@GetMapping("/verAsignacionRol")
	public String verAsignacionRol() {
		return "intranetAsignacionRol";
	}

	@GetMapping("/verConsultaContrato")
	public String verConsultaContrato() {
		return "intranetConsultaContrato";
	}

	@GetMapping("/verConsultaServicio")
	public String verConsultaServicio() {
		return "intranetConsultaServicio";
	}

}
