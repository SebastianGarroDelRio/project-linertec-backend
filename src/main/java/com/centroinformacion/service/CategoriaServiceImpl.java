package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

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
	public boolean eliminaCategoriaPorId(int idCategoria) {
		repository.deleteById(idCategoria);
		return true;
	}

	@Override
	public Optional<Categoria> listaCategoriaPorId(int idCategoria) {
		return repository.findById(idCategoria);
	}

	@Override
	public List<Categoria> listaCategoriaPorDescripcionDiferenteSiMismo( String descripcionCategoria, int idCategoria) {
		return repository.listaPorDescripcionDiferenteSiMismo(descripcionCategoria, idCategoria);
	}

	@Override
	public List<Categoria> listaCategoriaPorDescripcionDiferenteSiMismoActualiza(String descripcionCategoria, int idCategoria) {
		return repository.listaPorDescripcionDiferenteSiMismoActualiza(descripcionCategoria, idCategoria);
	}

	@Override
	public List<Categoria> listaConsultaCategoria(String descripcionCategoria, int idestado) {
		return repository.listaConsultaCategoriaComplejo(descripcionCategoria, idestado);
	}

}
