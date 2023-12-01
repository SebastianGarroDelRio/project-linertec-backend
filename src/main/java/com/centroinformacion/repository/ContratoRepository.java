package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

	@Query("Select x from Contrato x where x.cliente.idCliente = :param_cli")
	public abstract List<Contrato> listaContrato(@Param("param_cli") int idCliente);
	
	@Query("select c from Contrato c where "
			+ "( ?1 = -1 or c.estadoContrato.idEstadoContrato = ?1 )")
	public abstract List<Contrato> listaConsultaContratoComplejo(int idEstadoContrato);
		
}
