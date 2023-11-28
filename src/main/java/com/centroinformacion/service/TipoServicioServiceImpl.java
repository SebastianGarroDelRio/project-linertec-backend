package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.TipoServicio;
import com.centroinformacion.repository.TipoServicioRepository;

@Service
public class TipoServicioServiceImpl implements TipoServicioService {

	@Autowired
	private TipoServicioRepository repository;

	@Override
	public List<TipoServicio> listaTodos() {
		return repository.findAll();
	}
	
}
