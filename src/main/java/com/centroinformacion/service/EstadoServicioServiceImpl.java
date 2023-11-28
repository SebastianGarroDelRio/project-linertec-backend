package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.EstadoServicio;
import com.centroinformacion.repository.EstadoServicioRepository;

@Service
public class EstadoServicioServiceImpl implements EstadoServicioService{
	
	@Autowired
	private EstadoServicioRepository repository;
	
	@Override
	public List<EstadoServicio> listaTodos() {
		return repository.findAll();
	}

}
