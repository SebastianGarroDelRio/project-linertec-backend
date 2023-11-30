package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Categoria;

public interface CategoriaService {

	// COMBO
	public abstract List<Categoria> listaTodos();

	// FILTRAR
	public abstract List<Categoria> listaPorNombreCategoriaLike(String filtro);

	// INSERTA Y ACTUALIZA
	public abstract Categoria insertaActualizaCategoria(Categoria obj);

	// ELIMINA
	public abstract boolean eliminaCategoriaPorId(int idCategoria);

	// LISTAR POR UN ID
	public abstract Optional<Categoria> listaCategoriaPorId(int idCategoria);

}
