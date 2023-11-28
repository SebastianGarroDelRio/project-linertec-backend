package com.centroinformacion.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seleccion {

	private int idServicio;
	private String descripcionServicio;
	private double costoServicio;
	private int impuesto;
	private double totalParcial;

	public double getTotalParcial() {
		totalParcial = costoServicio * impuesto;
		return totalParcial;
	}

}
