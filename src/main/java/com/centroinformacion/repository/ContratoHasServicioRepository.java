package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.ContratoHasServicio;

public interface ContratoHasServicioRepository extends JpaRepository<ContratoHasServicio, Integer> {

	// @Modifying
	// @Query("update Producto x set x.stock = x.stock - :can where x.idProducto = :pro")
	// public abstract void actualizaStock(@Param("can")int cantidad,@Param("pro")int idProducto);

	@Query("Select x from ContratoHasServicio x where x.contrato.idContrato = :param_contrato")
	public abstract List<ContratoHasServicio> listaDetalle(@Param("param_contrato") int idContrato);
}
