package com.centroinformacion.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "contrato_has_servicio")
public class ContratoHasServicio {

	
	@EmbeddedId
	private ContratoHasServicioPK contratoHasServicioPK;
	private double costoServicio;
	private int impuesto;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idContrato", nullable = false, insertable = false, updatable = false)
	private Contrato contrato;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idServicio", nullable = false, insertable = false, updatable = false)
	private Servicio servicio;
	
	
	public String getReporteContrato() {
		return contrato.getIdContrato() + " - " + contrato.getDetallesContrato();
	}
	
	public String getReporteServicio() {
		return servicio.getIdServicio() + " - " + servicio.getDescripcionServicio();
	}

}
