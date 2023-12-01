package com.centroinformacion.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.entity.Estado;
import com.centroinformacion.service.CategoriaService;

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

@CommonsLog
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

		try {
	        boolean eliminacionExitosa = service.eliminaCategoriaPorId(id);
	        if (eliminacionExitosa) {
	            List<Categoria> lista = service.listaPorNombreCategoriaLike("%");
	            map.put("lista", lista);
	        } else {
	            map.put("mensaje", "Error al eliminar el registro");
	        }
	    } catch (DataIntegrityViolationException e) {
	        map.put("mensaje", "No se puede eliminar la categoría porque tiene productos asignados.");
	    }
		return map;
	}
	
	@GetMapping("/reporteCategoriaPdf")
	public void reporteCategoria(HttpServletRequest rq, HttpServletResponse rs, String descripcionCategoria, int estado)
	{
		try {
			// Obtengo el datasource que va a generar el reporte
			List<Categoria> lstSalida = service.listaConsultaCategoria("%"+descripcionCategoria+"%", estado);

			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstSalida);

			// Obtener el archivo que contiene el diseño del reporte
			String fileDirectory = rq.getServletContext().getRealPath("/WEB-INF/reportes/reporteCategorias.jasper");
			log.info(">> FILE >> " + fileDirectory);
			FileInputStream stream = new FileInputStream(new File(fileDirectory));

			// Parametros adicionales
			String fileLogo = rq.getServletContext().getRealPath("/static/images/logo.png");
			log.info(">> LOGO >> " + fileLogo);

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("LOGO", fileLogo);

			// Enviamos dataSource, diseño y parámetros para generar el PDF
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(stream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

			// PASO 5: Enviar el PDF generado
			rs.setContentType("application/x-pdf");
			rs.addHeader("Content-disposition", "attachment; filename=ReporteCategoria.pdf");

			OutputStream outStream = rs.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
