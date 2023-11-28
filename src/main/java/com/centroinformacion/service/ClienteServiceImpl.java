package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Cliente;
import com.centroinformacion.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listaTodos() {
		return repository.findAll();
	}

	// CRUD
	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaClientePorId(int idCliente) {
		repository.deleteById(idCliente);
	}

	@Override
	public Optional<Cliente> listaClientePorId(int idCliente) {
		return repository.findById(idCliente);
	}

	@Override
	public List<Cliente> listaPorNombreClienteLike(String filtro) {
		return repository.listaClienteNombreLike(filtro);
	}

	
	// INICIO VALIDACION REGISTRAR

	@Override
	public List<Cliente> listaClientePorTelefonoDiferenteSiMismo(String telefono, int idCliente) {
		return repository.listaPorTelefonoDiferenteSiMismo(telefono, idCliente);
	}

	@Override
	public List<Cliente> listaClientePorCorreoDiferenteSiMismo(String correo, int idCliente) {
		return repository.listaPorCorreoDiferenteSiMismo(correo, idCliente);
	}

	@Override
	public List<Cliente> listaClientePorDireccionDiferenteSiMismo(String direccion, int idCliente) {
		return repository.listaPorDireccionDiferenteSiMismo(direccion, idCliente);
	}

	// INICIO VALIDACION ACTUALIZA

	@Override
	public List<Cliente> listaClientePorTelefonoDiferenteSiMismoActualiza(String telefono, int idCliente) {
		return repository.listaPorTelefonoDiferenteSiMismoActualiza(telefono, idCliente);
	}

	@Override
	public List<Cliente> listaClientePorCorreoDiferenteSiMismoActualiza(String correo, int idCliente) {
		return repository.listaPorCorreoDiferenteSiMismoActualiza(correo, idCliente);
	}

	@Override
	public List<Cliente> listaClientePorDireccionDiferenteSiMismoActualiza(String direccion, int idCliente) {
		return repository.listaPorDireccionDiferenteSiMismoActualiza(direccion, idCliente);
	}

	
	//TRANSACCION
	@Override
	public List<Cliente> listaCliente(String filtro, Pageable pageable) {
		return repository.listaCliente(filtro, pageable);
	}

	@Override
	public List<Cliente> listaCliente() {
		return repository.listaCliente();
	}


}