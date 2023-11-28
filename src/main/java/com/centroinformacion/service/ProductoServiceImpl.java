package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Producto;
import com.centroinformacion.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository repository;

	@Override
	public List<Producto> listaTodos() {
		return repository.findAll();
	}
	
	@Override
	public List<Producto> listaPorNombreProductoLike(String filtro) {
		return repository.listaProductoNombreLike(filtro);
	}

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaProductoPorId(int idProducto) {
		repository.deleteById(idProducto);
	}

	@Override
	public Optional<Producto> listaProductoPorId(int idProducto) {
		return repository.findById(idProducto);
	}

}
