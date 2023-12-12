package com.centroinformacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnlaceController {
	
	@GetMapping("/")
    public String defaultMapping() {
        return "redirect:/verLogin";
    }

	@GetMapping("/verLogin")
	public String verLogin() {
		return "intranetLogin";
	}

	@GetMapping("/verIntranetHome")
	public String verIntranetHome() {
		return "intranetHome";
	}

	@GetMapping("/verCrudCategoria")
	public String verCrudCategoria(Model model) {
		return "intranetCrudCategoria";
	}

	@GetMapping("/verCrudCliente")
	public String verCrudCliente(Model model) {
		return "intranetCrudCliente";
	}

	@GetMapping("/verCrudContrato")
	public String verCrudContrato(Model model) {
		return "intranetCrudContrato";
	}

	@GetMapping("/verCrudDetalleServicio")
	public String verCrudDetalleServicio(Model model) {
		return "intranetCrudDetalleServicio";
	}

	@GetMapping("/verCrudProducto")
	public String verCrudProducto(Model model) {
		return "intranetCrudProducto";
	}

	@GetMapping("/verCrudProveedor")
	public String verCrudProveedor(Model model) {
		return "intranetCrudProveedor";
	}

	@GetMapping("/verCrudServicio")
	public String verCrudServicio(Model model) {
		return "intranetCrudServicio";
	}

	@GetMapping("/verCrudUsuario")
	public String verCrudUsuario(Model model) {
		return "intranetCrudUsuario";
	}

	@GetMapping("/verAsignacionRol")
	public String verAsignacionRol(Model model) {
		return "intranetAsignacionRol";
	}

	@GetMapping("/verConsultaContrato")
	public String verConsultaContrato(Model model) {
		return "intranetConsultaContrato";
	}

	@GetMapping("/verConsultaServicio")
	public String verConsultaServicio(Model model) {
		return "intranetConsultaServicio";
	}

}
