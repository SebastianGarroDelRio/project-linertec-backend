package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.EstadoContrato;
import com.centroinformacion.repository.EstadoContratoRepository;

@Service
public class EstadoContratoServiceImpl implements EstadoContratoService{
	
	@Autowired
	private EstadoContratoRepository repository;
	
	@Override
	public List<EstadoContrato> listaTodos() {
		return repository.findAll();
	}

}
