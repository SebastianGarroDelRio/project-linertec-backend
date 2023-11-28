package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Estado;
import com.centroinformacion.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	private EstadoRepository repository;
	
	@Override
	public List<Estado> listaTodos() {
		return repository.findAll();
	}

}
