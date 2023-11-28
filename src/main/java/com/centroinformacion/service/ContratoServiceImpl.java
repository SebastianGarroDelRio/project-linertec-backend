	package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Contrato;
import com.centroinformacion.entity.ContratoHasServicio;
import com.centroinformacion.repository.ContratoHasServicioRepository;
import com.centroinformacion.repository.ContratoRepository;

import jakarta.transaction.Transactional;




@Service
public class ContratoServiceImpl implements ContratoService{

	@Autowired
	private ContratoRepository repository;
	
	@Autowired
	private ContratoHasServicioRepository detalleRepository;

	@Override
	public List<Contrato> listaTodos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Contrato insertaActualizaContrato(Contrato obj) {
		Contrato cabecera = repository.save(obj);
		for (ContratoHasServicio d : cabecera.getDetallesContrato()) {
			d.getContratoHasServicioPK().setIdContrato(cabecera.getIdContrato());
			//detalleRepository.actualizaStock(d.getCantidad(), d.getProductoHasBoletaPK().getIdProducto());
			detalleRepository.save(d);
		}
		return cabecera;
	}

	@Override
	public void eliminaContratoPorId(int idContrato) {
		repository.deleteById(idContrato);
		
	}

	@Override
	public Optional<Contrato> listaContratoPorId(int idContrato) {
		return repository.findById(idContrato);
	}

	@Override 
	public List<Contrato> listaContrato(int idCliente) {
		return repository.listaContrato(idCliente);
	}

	@Override
	public List<ContratoHasServicio> listaDetalle(int idContrato) {
		return detalleRepository.listaDetalle(idContrato);
	}
	


	


}
