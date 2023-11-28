package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.TipoDocumento;
import com.centroinformacion.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
	
	@Autowired
	private TipoDocumentoRepository repository;

	@Override
	public List<TipoDocumento> listaTodos() {
		return repository.findAll();
	}

}
