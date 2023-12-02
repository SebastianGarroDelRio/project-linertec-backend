package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.ContratoHasServicio;
import com.centroinformacion.repository.ContratoHasServicioRepository;

@Service
public class  ContratoHasServicioServiceImpl implements ContratoHasServicioService  {

	@Autowired
	private ContratoHasServicioRepository rep;

	@Override
	public List<ContratoHasServicio> listaTodos(int idContrato) {
		return rep.listaDetalle(idContrato);
	}



}
