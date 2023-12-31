package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract List<Usuario> buscaPorLogin(String login);

	// LISTAR COMBO
	public abstract List<Usuario> listaTodos();

	// FILTRAR
	public abstract List<Usuario> listaPorNombreUsuarioLike(String filtro);

	// INSERTA Y ACTUALIZA
	public abstract Usuario insertaActualizaUsuario(Usuario obj);

	// ELIMINAR
	public abstract void eliminaUsuarioPorId(int idUsuario);

	// LISTA POR UN ID
	public abstract Optional<Usuario> listaUsuarioPorId(int idUsuario);

	// VALIDACIONES
	public abstract List<Usuario> listaUsuarioPorDniDiferenteSiMismo(String dni, int idUsuario);
	public abstract List<Usuario> listaUsuarioPorLoginDiferenteSiMismo(String login, int idUsuario);
	public abstract List<Usuario> listaUsuarioPorCorreoDiferenteSiMismo(String correo, int idUsuario);
	public abstract List<Usuario> listarPorCorreo(String correo);

	
	public abstract List<Usuario> listaUsuarioPorDniDiferenteSiMismoActualiza(String dni, int idUsuario);
	public abstract List<Usuario> listaUsuarioPorLoginDiferenteSiMismoActualiza(String login, int idUsuario);
	public abstract List<Usuario> listaUsuarioPorCorreoDiferenteSiMismoActualiza(String correo, int idUsuario);
	
}
