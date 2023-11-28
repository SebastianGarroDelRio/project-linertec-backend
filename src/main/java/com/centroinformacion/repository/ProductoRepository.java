package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("select p from Producto p where p.descripcionProducto like ?1 ")
	public List<Producto> listaProductoNombreLike(String filtro);
	
}
