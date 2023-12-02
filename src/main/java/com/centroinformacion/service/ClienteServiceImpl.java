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

	//TRANSACCION
	@Override
	public List<Cliente> listaCliente(String filtro, Pageable pageable) {
		return repository.listaCliente(filtro, pageable);
	}

}