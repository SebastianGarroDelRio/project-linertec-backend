package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query("select p from Categoria p where p.descripcionCategoria like ?1 ")
	public List<Categoria> listaCategoriaNombreLike(String filtro);

	// VALIDACIONES PARA REGISTRAR
	@Query("select c from Categoria c where c.descripcionCategoria = ?1 and c.idCategoria <> ?2")
	public List<Categoria> listaPorDescripcionDiferenteSiMismo(String descripcionCategoria, int idCategoria);
	@Query("select c from Categoria c where c.descripcionCategoria = ?1 and c.idCategoria != ?2 ")
	public List<Categoria> listaPorDescripcionDiferenteSiMismoActualiza(String descripcionCategoria, int idCategoria);

	@Query("select c from Categoria c where "
			+ "( c.descripcionCategoria like ?1 ) and "
			+ "( ?2 = -1 or c.estado.idestado = ?2 )")
	public List<Categoria> listaConsultaCategoriaComplejo(String descripcionCategoria, int idestado);
	
}
