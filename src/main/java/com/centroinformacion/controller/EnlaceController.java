package com.centroinformacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class EnlaceController {
	
	@GetMapping("")
	@ResponseBody
	public String Inicio() {
		return "Inicio";
	}
	
	@GetMapping("/nosotros")
	@ResponseBody
	public String Nosotros() {
		return "Nosotros";
	}
	
	@GetMapping("/servicios")
	@ResponseBody
	public String Servicios() {
		return "Servicios";
	}
	
	@GetMapping("/proyectos")
	@ResponseBody
	public String Proyectos() {
		return "Proyectos";
	}
	
	@GetMapping("/contactanos")
	@ResponseBody
	public String Contactanos() {
		return "Contactanos";
	}
	
	
	@GetMapping("/verLogin")
	@ResponseBody
	public String verLogin() {	return "intranetLogin";  }
	
	@GetMapping("/verIntranetHome")
	@ResponseBody
	public String verIntranetHome() {	return "intranetHome";  }
	
	@GetMapping("/verCrudCategoria")
	@ResponseBody
	public String verCrudCategoria() {	return "intranetCrudCategoria";	}

	@GetMapping("/verCrudCliente")
	@ResponseBody
	public String verCrudCliente() {	return "intranetCrudCliente";	}

	@GetMapping("/verCrudContrato")
	@ResponseBody
	public String verCrudContrato() {	return "intranetCrudContrato";	}

	@GetMapping("/verCrudDetalleServicio")
	@ResponseBody
	public String verCrudDetalleServicio() {	return "intranetCrudDetalleServicio";	}

	@GetMapping("/verCrudProducto")
	@ResponseBody
	public String verCrudProducto() {	return "intranetCrudProducto";	}

	@GetMapping("/verCrudProveedor")
	@ResponseBody
	public String verCrudProveedor() {	return "intranetCrudProveedor";	}

	@GetMapping("/verCrudServicio")
	@ResponseBody
	public String verCrudServicio() {	return "intranetCrudServicio";	}
	
	@GetMapping("/verCrudUsuario")
	@ResponseBody
	public String verCrudUsuario() {	return "intranetCrudUsuario";	}
	
	@GetMapping("/verAsignacionRol")
	@ResponseBody
	public String verAsignacionRol() {	return "intranetAsignacionRol";	}
	
	@GetMapping("/verConsultaContrato")
	@ResponseBody
	public String verConsultaContrato() {	return "intranetConsultaContrato";	}
	
	@GetMapping("/verConsultaServicio")
	@ResponseBody
	public String verConsultaServicio() {	return "intranetConsultaServicio";	}

}
