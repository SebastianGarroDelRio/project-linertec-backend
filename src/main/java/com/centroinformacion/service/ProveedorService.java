package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorService {
	
	//COMBO
	public abstract List<Proveedor> listaTodos();
	
	//INSERTA Y ACTUALIZA
	public abstract Proveedor insertaActualizaProveedor(Proveedor obj);
	public abstract void eliminaProveedorPorId(int idProveedor);
	public abstract Optional<Proveedor> listaProveedorPorId(int idProveedor);
	
	
	
	public abstract List<Proveedor> listaProvedorNombreIgualActualiza(String nombreProveedor, int idProveedor);
	public abstract List<Proveedor> listaProvedorTelefonoIgualActualiza(String telefono, int idProveedor);
	public abstract List<Proveedor> listaProvedorDireccionIgualActualiza(String direccion, int idProveedor);
	public abstract List<Proveedor> listaProvedorCorreoIgualActualiza(String correo, int idProveedor);
	
	public abstract List<Proveedor> listaPorNombreLike(String filtro);
	public abstract List<Proveedor> listaPorTelefonoLike(String filtro);
	public abstract List<Proveedor> listaPorDireccionLike(String filtro);
	public abstract List<Proveedor> listaPorCorreoLike(String filtro);

}
