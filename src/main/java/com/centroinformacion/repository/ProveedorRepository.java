package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
  
	@Query("SELECT e FROM Proveedor e WHERE e.nombreProveedor = ?1 AND e.idProveedor <> ?2 AND e.idProveedor != ?3")
	public List<Proveedor> listaProvedorNombreIgualActualiza(String nombreProveedor, int idProveedor);

	@Query("SELECT e FROM Proveedor e WHERE e.telefono = ?1 AND e.idProveedor <> ?2 AND e.idProveedor != ?3")
	public List<Proveedor> listaProvedorTelefonoIgualActualiza(String telefono, int idProveedor);

	@Query("SELECT e FROM Proveedor e WHERE e.direccion = ?1 AND e.idProveedor <> ?2 AND e.idProveedor != ?3")
	public List<Proveedor> listaProvedorDireccionIgualActualiza(String direccion, int idProveedor);

	@Query("SELECT e FROM Proveedor e WHERE e.correo = ?1 AND e.idProveedor <> ?2 AND e.idProveedor != ?3")
	public List<Proveedor> listaProvedorCorreoIgualActualiza(String correo, int idProveedor);

	@Query("SELECT e FROM Proveedor e WHERE e.nombreProveedor LIKE ?1")
	public List<Proveedor> listaPorNombreLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.telefono LIKE ?1")
	public List<Proveedor> listaPorTelefonoLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.direccion LIKE ?1")
	public List<Proveedor> listaPorDireccionLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.correo LIKE ?1")
	public List<Proveedor> listaPorCorreoLike(String filtro);
	    
	
	
}
