package com.centroinformacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class EnlaceController {
	
	@RequestMapping("")
	public String Inicio() {
		return "Inicio";
	}
	
	@RequestMapping("/nosotros")
	public String Nosotros() {
		return "Nosotros";
	}
	
	@RequestMapping("/servicios")
	public String Servicios() {
		return "Servicios";
	}
	
	@RequestMapping("/proyectos")
	public String Proyectos() {
		return "Proyectos";
	}
	
	@RequestMapping("/contactanos")
	public String Contactanos() {
		return "Contactanos";
	}
	
	
	@RequestMapping("/verLogin")
	public String verLogin() {	return "intranetLogin";  }
	
	@RequestMapping("/verIntranetHome")
	public String verIntranetHome() {	return "intranetHome";  }
	
	@RequestMapping("/verCrudCategoria")
	public String verCrudCategoria() {	return "intranetCrudCategoria";	}

	@RequestMapping("/verCrudCliente")
	public String verCrudCliente() {	return "intranetCrudCliente";	}

	@RequestMapping("/verCrudContrato")
	public String verCrudContrato() {	return "intranetCrudContrato";	}

	@RequestMapping("/verCrudDetalleServicio")
	public String verCrudDetalleServicio() {	return "intranetCrudDetalleServicio";	}

	@RequestMapping("/verCrudProducto")
	public String verCrudProducto() {	return "intranetCrudProducto";	}

	@RequestMapping("/verCrudProveedor")
	public String verCrudProveedor() {	return "intranetCrudProveedor";	}

	@RequestMapping("/verCrudServicio")
	public String verCrudServicio() {	return "intranetCrudServicio";	}
	
	@RequestMapping("/verCrudUsuario")
	public String verCrudUsuario() {	return "intranetCrudUsuario";	}
	
	@RequestMapping("/verAsignacionRol")
	public String verAsignacionRol() {	return "intranetAsignacionRol";	}
	
	@RequestMapping("/verConsultaContrato")
	public String verConsultaContrato() {	return "intranetConsultaContrato";	}
	
	@RequestMapping("/verConsultaServicio")
	public String verConsultaServicio() {	return "intranetConsultaServicio";	}

}
