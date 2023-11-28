package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Producto;

public interface ProductoService {

	//COMBO
	public abstract List<Producto> listaTodos();
	
	//FILTRAR
	public abstract List<Producto> listaPorNombreProductoLike(String filtro);
	
	//INSERTA Y ACTUALIZA
	public abstract Producto insertaActualizaProducto(Producto obj);
	
	//ELIMINA
	public abstract void eliminaProductoPorId(int idProducto);
	
	//LISTAR POR UN ID
	public abstract Optional<Producto> listaProductoPorId(int idProducto);

}
