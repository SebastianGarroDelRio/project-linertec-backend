package com.centroinformacion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_estadocontrato")
public class EstadoContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstadoContrato;
	private String descripcionEstadoContrato;

}
