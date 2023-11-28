package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> listaTodos() {
		return repository.findAll();
	}
    
	// Validacion 
	
	@Override
	public List<Proveedor> listaProvedorNombreIgualActualiza(String nombreProveedor, int idProveedor) {
		return repository.listaProvedorNombreIgualActualiza(nombreProveedor, idProveedor);
	}

	@Override
	public List<Proveedor> listaProvedorTelefonoIgualActualiza(String telefono, int idProveedor) {
		return repository.listaProvedorTelefonoIgualActualiza(telefono, idProveedor);			
	}

	@Override
	public List<Proveedor> listaProvedorDireccionIgualActualiza(String direccion, int idProveedor) {
	    return repository.listaProvedorDireccionIgualActualiza(direccion, idProveedor);
	}

	@Override
	public List<Proveedor> listaProvedorCorreoIgualActualiza(String correo, int idProveedor) {
		return repository.listaProvedorCorreoIgualActualiza(correo, idProveedor);
				
	}
 
	
	//
	@Override
	public List<Proveedor> listaPorNombreLike(String filtro) {
	    return repository.listaPorNombreLike(filtro);
	}

	@Override
	public List<Proveedor> listaPorTelefonoLike(String filtro) {
		return repository.listaPorTelefonoLike(filtro);
	}

	@Override
	public List<Proveedor> listaPorDireccionLike(String filtro) {
		return repository.listaPorDireccionLike(filtro);
	}

	@Override
	public List<Proveedor> listaPorCorreoLike(String filtro) {
		return repository.listaPorCorreoLike(filtro);
	}
	
	
	//CRUD
	@Override
	public Proveedor insertaActualizaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaProveedorPorId(int idProveedor) {
		repository.deleteById(idProveedor);
	}

	@Override
	public Optional<Proveedor> listaProveedorPorId(int idProveedor) {
		return repository.findById(idProveedor);
	}
	
	
	
}
