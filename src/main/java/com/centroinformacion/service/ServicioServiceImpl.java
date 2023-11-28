package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Servicio;
import com.centroinformacion.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{
	
	@Autowired
	private ServicioRepository repository;

	@Override
	public Servicio insertaActualizaServicio(Servicio obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaServicioPorId(int idServicio) {
		repository.deleteById(idServicio);
	}

	@Override
	public List<Servicio> listaPorNombreServicioLike(String filtro) {
		return repository.listaServicioNombreLike(filtro);
	}

	@Override
	public Optional<Servicio> listaServicioPorId(int idServicio) {
		return repository.findById(idServicio);
	}

	@Override
	public List<Servicio> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Servicio> listaservicio(String filtro, Pageable pageable) {
		return repository.listaservicio(filtro, pageable);
	}


}
