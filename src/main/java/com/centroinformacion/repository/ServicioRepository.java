package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

	@Query("select s from Servicio s where s.descripcionServicio like ?1 ")
	public List<Servicio> listaServicioNombreLike(String filtro);

	/*
	 * @Query("Select x from Servicio x where x.descripcionServicio like :var_fil")
	 * public List<Servicio> listaservicio(@Param("var_fil") String filtro, Pageable
	 * pageable);
	 */
	
	@Query("select x from Servicio x where x.descripcionServicio like ?1")
	public abstract List<Servicio> listaServicio(String filtro, Pageable pageable);

}
