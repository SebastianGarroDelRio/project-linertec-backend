package com.centroinformacion.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Cliente;
import com.centroinformacion.entity.Contrato;
import com.centroinformacion.entity.ContratoHasServicio;
import com.centroinformacion.entity.ContratoHasServicioPK;
import com.centroinformacion.entity.EstadoContrato;
import com.centroinformacion.entity.Mensaje;
import com.centroinformacion.entity.Seleccion;
import com.centroinformacion.entity.Servicio;
import com.centroinformacion.service.ClienteService;
import com.centroinformacion.service.ContratoHasServicioService;
import com.centroinformacion.service.ContratoService;
import com.centroinformacion.service.ServicioService;
import com.centroinformacion.util.FunctionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.apachecommons.CommonsLog;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class ContratoController {

	@Autowired
	private ContratoService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private ContratoHasServicioService contratoService;

	// Los productos seleccionados
	private List<Seleccion> seleccionados = new ArrayList<Seleccion>();

	@GetMapping("/cargaCliente")
	@ResponseBody()
	public List<Cliente> listaCliente(String filtro) {
		int page = 0;
		int size = 5;
		Pageable pageable = PageRequest.of(page, size);
		List<Cliente> lstSalida = clienteService.listaCliente("%" + filtro + "%", pageable);
		return lstSalida;
	}

	@GetMapping("/cargaServicio")
	@ResponseBody()
	public List<Servicio> listaServicio(String filtro) {
		int page = 0;
		int size = 5;
		Pageable pageable = PageRequest.of(page, size);
		List<Servicio> lstSalida = servicioService.listaservicio("%" + filtro + "%", pageable);
		return lstSalida;
	}

	@GetMapping("/listaSeleccion")
	@ResponseBody()
	public List<Seleccion> lista() {
		return this.seleccionados;
	}

	@PostMapping("/agregarSeleccion")
	@ResponseBody()
	public List<Seleccion> agregar(Seleccion obj) {
		seleccionados.add(obj);
		return this.seleccionados;
	}

	@DeleteMapping("/eliminaSeleccion")
	@ResponseBody()
	public List<Seleccion> eliminar(int idServicio) {
		seleccionados.removeIf(x -> x.getIdServicio() == idServicio);
		return seleccionados;
	}

	@PostMapping("/registraContrato")
	@ResponseBody()
	public Mensaje contrato(Cliente cliente, @RequestParam String fechaInicio, @RequestParam String fechaFin, HttpSession session) {
		Mensaje objMensaje = new Mensaje();

		List<ContratoHasServicio> detalles = new ArrayList<ContratoHasServicio>();
		for (Seleccion seleccion : seleccionados) {

			ContratoHasServicioPK pk = new ContratoHasServicioPK();
			pk.setIdServicio(seleccion.getIdServicio());

			ContratoHasServicio psb = new ContratoHasServicio();
			psb.setCostoServicio(seleccion.getCostoServicio());
			psb.setImpuesto(seleccion.getImpuesto());
			psb.setContratoHasServicioPK(pk);

			detalles.add(psb);
		}

		Contrato obj = new Contrato();
		obj.setFechaInicio(FunctionUtil.getFechaDate(fechaInicio));
		obj.setFechaFin(FunctionUtil.getFechaDate(fechaFin));
		obj.setCliente(cliente);
		obj.setDetallesContrato(detalles);

		// Probando si pasa estado con 1
		EstadoContrato objEstado = new EstadoContrato();
		objEstado.setIdEstadoContrato(1);
		
		obj.setEstadoContrato(objEstado);

		Contrato objContrato = service.insertaActualizaContrato(obj);

		String salida = "-1";

		if (objContrato != null) {
			salida = "Se generó la boleta con código N° : " + objContrato.getIdContrato() + "<br><br>";
			salida += "Cliente: " + obj.getCliente().getNombreCliente() + "<br><br>";
			salida += "Fecha Inicio : " + obj.getFechaInicio() + "<br><br>"
					+ "Fecha Fin : " + obj.getFechaFin() + "<br><br>";
			
			salida += "<table class=\"table\"><tr>" + "<td>Servicio</td>" + "<td>Costo</td>" + "<td>Impuesto</td>" + "<td>Subtotal</td></tr>";
			
			double monto = 0;
			for (Seleccion x : seleccionados) {
				salida += "<tr><td>" + x.getDescripcionServicio() + "</td><td>" + x.getCostoServicio() + "</td><td>"
						+ x.getImpuesto() + "</td><td>" + x.getTotalParcial() + "</td></tr>";
				monto += x.getImpuesto() * x.getCostoServicio();
			}
			salida += "</table><br>";
			salida += "Monto a pagar : " + monto;

			seleccionados.clear();
			objMensaje.setTexto(salida);
		}

		return objMensaje;
	}

	
}
