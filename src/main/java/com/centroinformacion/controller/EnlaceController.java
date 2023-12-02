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
		return "Inicio.jsp";
	}
	
	@GetMapping("/nosotros")
	@ResponseBody
	public String Nosotros() {
		return "Nosotros.jsp";
	}
	
	@GetMapping("/servicios")
	@ResponseBody
	public String Servicios() {
		return "Servicios.jsp";
	}
	
	@GetMapping("/proyectos")
	@ResponseBody
	public String Proyectos() {
		return "Proyectos.jsp";
	}
	
	@GetMapping("/contactanos")
	@ResponseBody
	public String Contactanos() {
		return "Contactanos.jsp";
	}
	
	
	@GetMapping("/verLogin")
	@ResponseBody
	public String verLogin() {	return "intranetLogin.jsp";  }
	
	@GetMapping("/verIntranetHome")
	@ResponseBody
	public String verIntranetHome() {	return "intranetHome.jsp";  }
	
	@GetMapping("/verCrudCategoria")
	@ResponseBody
	public String verCrudCategoria() {	return "intranetCrudCategoria.jsp";	}

	@GetMapping("/verCrudCliente")
	@ResponseBody
	public String verCrudCliente() {	return "intranetCrudCliente.jsp";	}

	@GetMapping("/verCrudContrato")
	@ResponseBody
	public String verCrudContrato() {	return "intranetCrudContrato.jsp";	}

	@GetMapping("/verCrudDetalleServicio")
	@ResponseBody
	public String verCrudDetalleServicio() {	return "intranetCrudDetalleServicio.jsp";	}

	@GetMapping("/verCrudProducto")
	@ResponseBody
	public String verCrudProducto() {	return "intranetCrudProducto.jsp";	}

	@GetMapping("/verCrudProveedor")
	@ResponseBody
	public String verCrudProveedor() {	return "intranetCrudProveedor.jsp";	}

	@GetMapping("/verCrudServicio")
	@ResponseBody
	public String verCrudServicio() {	return "intranetCrudServicio.jsp";	}
	
	@GetMapping("/verCrudUsuario")
	@ResponseBody
	public String verCrudUsuario() {	return "intranetCrudUsuario.jsp";	}
	
	@GetMapping("/verAsignacionRol")
	@ResponseBody
	public String verAsignacionRol() {	return "intranetAsignacionRol.jsp";	}
	
	@GetMapping("/verConsultaContrato")
	@ResponseBody
	public String verConsultaContrato() {	return "intranetConsultaContrato.jsp";	}
	
	@GetMapping("/verConsultaServicio")
	@ResponseBody
	public String verConsultaServicio() {	return "intranetConsultaServicio.jsp";	}

}
