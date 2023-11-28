package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository repository;
	
	@Override
	public List<Categoria> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Categoria> listaPorNombreCategoriaLike(String filtro) {
		return repository.listaCategoriaNombreLike(filtro);
	}

	@Override
	public Categoria insertaActualizaCategoria(Categoria obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaCategoriaPorId(int idCategoria) {
		repository.deleteById(idCategoria);
	}

	@Override
	public Optional<Categoria> listaCategoriaPorId(int idCategoria) {
		return repository.findById(idCategoria);
	}
	
	
	
	
}
