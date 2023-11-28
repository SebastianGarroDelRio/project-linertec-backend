package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.entity.Cliente;
import com.centroinformacion.entity.Estado;
import com.centroinformacion.entity.EstadoContrato;
import com.centroinformacion.entity.EstadoServicio;
import com.centroinformacion.entity.Producto;
import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.entity.Servicio;
import com.centroinformacion.entity.TipoDocumento;
import com.centroinformacion.entity.TipoServicio;
import com.centroinformacion.service.CategoriaService;
import com.centroinformacion.service.ClienteService;
import com.centroinformacion.service.EstadoContratoService;
import com.centroinformacion.service.EstadoService;
import com.centroinformacion.service.EstadoServicioService;
import com.centroinformacion.service.ProductoService;
import com.centroinformacion.service.ProveedorService;
import com.centroinformacion.service.ServicioService;
import com.centroinformacion.service.TipoDocumentoService;
import com.centroinformacion.service.TipoServicioService;

@Controller
public class UtilController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@Autowired
	private TipoServicioService tipoServicioService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private EstadoContratoService estadoContratoService;

	@Autowired
	private EstadoServicioService estadoServicioService;
	
	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("/listaServicio")
	@ResponseBody
	public List<Servicio> listaServicio() {
		return servicioService.listaTodos();
	}
	
	@GetMapping("/listaProducto")
	@ResponseBody
	public List<Producto> listaProducto() {
		return productoService.listaTodos();
	}
	
	@GetMapping("/listaCategoria")
	@ResponseBody
	public List<Categoria> listaCategoria() {
		return categoriaService.listaTodos();
	}
	
	@GetMapping("/listaProveedor")
	@ResponseBody
	public List<Proveedor> listaProveedor() {
		return proveedorService.listaTodos();
	}
	
	@GetMapping("/listaTipoDocumento")
	@ResponseBody
	public List<TipoDocumento> listaTipoDocumento() {
		return tipoDocumentoService.listaTodos();
	}

	@GetMapping("/listaTipoServicio")
	@ResponseBody
	public List<TipoServicio> listaTipoServicio() {
		return tipoServicioService.listaTodos();
	}

	@GetMapping("/listaEstado")
	@ResponseBody
	public List<Estado> listaEstado() {
		return estadoService.listaTodos();
	}
	
	@GetMapping("/listaEstadoServicio")
	@ResponseBody
	public List<EstadoServicio> listaEstadoServicio() {
		return estadoServicioService.listaTodos();
	}
	
	@GetMapping("/listaEstadoContrato")
	@ResponseBody
	public List<EstadoContrato> listaEstadoContrato() {
		return estadoContratoService.listaTodos();
	}
	
	@GetMapping("/listaCliente")
	@ResponseBody
	public List<Cliente> listaCliente() {
		return clienteService.listaTodos();
	}
	
}
