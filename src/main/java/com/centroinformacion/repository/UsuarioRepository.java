package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);

	@Query("Select p from Opcion p, RolHasOpcion pr, Rol r, UsuarioHasRol u where  p.idOpcion = pr.opcion.idOpcion and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
	public abstract List<Opcion> traerEnlacesDeUsuario(@Param("var_idUsuario") int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = :var_idUsuario")
	public abstract List<Rol> traerRolesDeUsuario(@Param("var_idUsuario") int idUsuario);

	public abstract List<Usuario> findByLoginIgnoreCase(String login);

	// FILTRAR
	@Query("select u from Usuario u where u.nombres like ?1 ")
	public List<Usuario> listaUsuarioNombreLike(String filtro);

	// VALIDACIONES
	@Query("select u from Usuario u where u.dni = ?1 and u.idUsuario <> ?2 ")
	public List<Usuario> listaPorDniDiferenteSiMismo(String dni, int idUsuario);

	@Query("select u from Usuario u where u.login = ?1 and u.idUsuario <> ?2 ")
	public List<Usuario> listaPorLoginDiferenteSiMismo(String login, int idUsuario);

	@Query("select u from Usuario u where u.correo = ?1 and u.idUsuario <> ?2 ")
	public List<Usuario> listaPorCorreoDiferenteSiMismo(String correo, int idUsuario);

	// VALIDACIONES PARA ACTUALIZAR
	@Query("select u from Usuario u where u.login = ?1 and u.idUsuario != ?2 ")
	public List<Usuario> listaPorLoginDiferenteSiMismoActualiza(String login, int idUsuario);

	@Query("select u from Usuario u where u.dni = ?1 and u.idUsuario != ?2 ")
	public List<Usuario> listaPorDniDiferenteSiMismoActualiza(String dni, int idUsuario);

	@Query("select u from Usuario u where u.correo = ?1 and u.idUsuario != ?2 ")
	public List<Usuario> listaPorCorreoDiferenteSiMismoActualiza(String correo, int idUsuario);


	public abstract List<Usuario> findByCorreoIgnoreCase(String login);
}
