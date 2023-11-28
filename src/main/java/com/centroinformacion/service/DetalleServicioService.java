package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;


import com.centroinformacion.entity.DetalleServicio;

public interface DetalleServicioService {

	public abstract List<DetalleServicio> listaDetalleServicio();
	
	public abstract DetalleServicio insertaActualizaCDetalleServicio(DetalleServicio obj);
	
	public abstract Optional<DetalleServicio> listaCategoriaPorId(int idDetalleServicio);
	
}
