package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	// VALIDACIONES PARA REGISTRAR
	@Query("select e from Cliente e where e.telefono = ?1 and e.idCliente <> ?2 ")
	public List<Cliente> listaPorTelefonoDiferenteSiMismo(String telefono, int idCliente);

	
	// FILTRAR
	@Query("select p from Cliente p where p.nombreCliente like ?1 ")
	public List<Cliente> listaClienteNombreLike(String filtro);
	
	
	/*
	 * @Query("Select x from Cliente x where nombreCliente like :var_filtro") public
	 * abstract List<Cliente> listaCliente(@Param("var_filtro") String filtro,
	 * Pageable pageable);
	 * 
	 * @Query("Select x from Cliente x order by x.nombreCliente asc") public
	 * abstract List<Cliente> listaCliente();
	 */
	
	@Query("select x from Cliente x where x.nombreCliente like ?1 ")
	public abstract List<Cliente> listaCliente (String filtro, Pageable pageable);
	
}
