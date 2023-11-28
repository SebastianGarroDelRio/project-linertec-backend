package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.DetalleServicio;
import com.centroinformacion.repository.DetalleServicioRepository;

@Service
public class DetalleServicioServiceImpl implements DetalleServicioService{

	@Autowired
	private DetalleServicioRepository repository;
	
	@Override
	public List<DetalleServicio> listaDetalleServicio() {
		return repository.findAll();
	}

	@Override
	public DetalleServicio insertaActualizaCDetalleServicio(DetalleServicio obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<DetalleServicio> listaCategoriaPorId(int idDetalleServicio) {
		return repository.findById(idDetalleServicio);
	}
	
    
}
