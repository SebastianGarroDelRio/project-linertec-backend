package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Contrato;
import com.centroinformacion.entity.ContratoHasServicio;

public interface ContratoService {
	
	public abstract List<Contrato> listaTodos();
	
	// INSERTA Y ACTUALIZA
	public abstract Contrato insertaActualizaContrato(Contrato obj);

	// ELIMINAR
	public abstract void eliminaContratoPorId(int idContrato);

	// LISTA POR UN ID
	public abstract Optional<Contrato> listaContratoPorId(int idContrato);
	
	
	//TRANSACCION
	public abstract List<Contrato> listaContrato(int idCliente);
	public abstract List<ContratoHasServicio> listaDetalle(int idContrato);
	
	
}
