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
	
	public abstract List<Proveedor> listaPorNombreLike(String filtro);
	public abstract List<Proveedor> listaPorTelefonoLike(String filtro);
	public abstract List<Proveedor> listaPorDireccionLike(String filtro);
	public abstract List<Proveedor> listaPorCorreoLike(String filtro);
	
	public abstract List<Proveedor> listaProveedorPorNombreDiferenteSiMismo(String nombreProveedor, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorCorreoDiferenteSiMismo(String correo, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorTelefonoDiferenteSiMismo(String telefono, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorDireccionDiferenteSiMismo(String direccion, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorTelefonoContactoDiferenteSiMismo(String telefonoContacto, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorNumeroDocumentoDiferenteSiMismo(String numeroDocumento, int idProveedor);
	
	public abstract List<Proveedor> listaProveedorPorNombreDiferenteSiMismoActualiza(String nombreProveedor, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorCorreoDiferenteSiMismoActualiza(String correo, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorTelefonoDiferenteSiMismoActualiza(String telefono, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorDireccionDiferenteSiMismoActualiza(String direccion, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorTelefonoContactoDiferenteSiMismoActualiza(String telefonoContacto, int idProveedor);
	public abstract List<Proveedor> listaProveedorPorNumeroDocumentoDiferenteSiMismoActualiza(String numeroDocumento, int idProveedor);

}
