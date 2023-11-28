package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.centroinformacion.entity.Servicio;

public interface ServicioService {
	
	public abstract List<Servicio> listaTodos();
	
	// FILTRAR
	public abstract List<Servicio> listaPorNombreServicioLike(String filtro);

	public abstract Servicio insertaActualizaServicio(Servicio obj);

	public abstract void eliminaServicioPorId(int idServicio);

	public abstract Optional<Servicio> listaServicioPorId(int idServicio);
	
	public abstract List<Servicio> listaservicio (String filtro, Pageable pageable);
	
}
