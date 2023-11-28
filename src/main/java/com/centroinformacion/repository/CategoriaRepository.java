package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	@Query("select p from Categoria p where p.descripcionCategoria like ?1 ")
	public List<Categoria> listaCategoriaNombreLike(String filtro);

}
