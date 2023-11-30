package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> listaTodos() {
		return repository.findAll();
	}

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

	// CRUD
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

	@Override
	public List<Proveedor> listaProveedorPorNombreDiferenteSiMismo(String nombreProveedor, int idProveedor) {
		return repository.listaPorNombreDiferenteSiMismo(nombreProveedor, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorCorreoDiferenteSiMismo(String correo, int idProveedor) {
		return repository.listaPorCorreoDiferenteSiMismo(correo, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorTelefonoDiferenteSiMismo(String telefono, int idProveedor) {
		return repository.listaPorTelefonoDiferenteSiMismo(telefono, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorDireccionDiferenteSiMismo(String direccion, int idProveedor) {
		return repository.listaPorNombreDiferenteSiMismo(direccion, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorTelefonoContactoDiferenteSiMismo(String telefonoContacto, int idProveedor) {
		return repository.listaPorTelefonoContactoDiferenteSiMismo(telefonoContacto, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorNumeroDocumentoDiferenteSiMismo(String numeroDocumento, int idProveedor) {
		return repository.listaPornumeroDocumentoDiferenteSiMismo(numeroDocumento, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorNombreDiferenteSiMismoActualiza(String nombreProveedor, int idProveedor) {
		return repository.listaPorNombreDiferenteSiMismoActualiza(nombreProveedor, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorCorreoDiferenteSiMismoActualiza(String correo, int idProveedor) {
		return repository.listaPorCorreoDiferenteSiMismoActualiza(correo, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorTelefonoDiferenteSiMismoActualiza(String telefono, int idProveedor) {
		return repository.listaPorTelefonoDiferenteSiMismoActualiza(telefono, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorDireccionDiferenteSiMismoActualiza(String direccion, int idProveedor) {
		return repository.listaPorDireccionDiferenteSiMismoActualiza(direccion, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorTelefonoContactoDiferenteSiMismoActualiza(String telefonoContacto,
			int idProveedor) {
		return repository.listaPorTelefonoContactoDiferenteSiMismoActualiza(telefonoContacto, idProveedor);
	}

	@Override
	public List<Proveedor> listaProveedorPorNumeroDocumentoDiferenteSiMismoActualiza(String numeroDocumento,
			int idProveedor) {
		return repository.listaPornumeroDocumentoDiferenteSiMismoActualiza(numeroDocumento, idProveedor);
	}

}
