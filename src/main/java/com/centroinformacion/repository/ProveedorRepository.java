package com.centroinformacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

	@Query("SELECT e FROM Proveedor e WHERE e.nombreProveedor LIKE ?1")
	public List<Proveedor> listaPorNombreLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.telefono LIKE ?1")
	public List<Proveedor> listaPorTelefonoLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.direccion LIKE ?1")
	public List<Proveedor> listaPorDireccionLike(String filtro);

	@Query("SELECT e FROM Proveedor e WHERE e.correo LIKE ?1")
	public List<Proveedor> listaPorCorreoLike(String filtro);
	
	// VALIDACIONES
	@Query("SELECT e FROM Proveedor e WHERE e.nombreProveedor = ?1 and e.idProveedor <> ?2 ")
	public List<Proveedor> listaPorNombreDiferenteSiMismo(String nombreProveedor, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.correo = ?1 and e.idProveedor <> ?2 ")
	public List<Proveedor> listaPorCorreoDiferenteSiMismo(String correo, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.telefono = ?1 AND e.idProveedor <> ?2 ")
	public List<Proveedor> listaPorTelefonoDiferenteSiMismo(String telefono, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.telefonoContacto = ?1 AND e.idProveedor <> ?2 ")
	public List<Proveedor> listaPorTelefonoContactoDiferenteSiMismo(String telefonoContacto, int idProveedor);
	@Query("select e from Proveedor e where e.numeroDocumento = ?1 and e.idProveedor <> ?2 ")
	public List<Proveedor> listaPornumeroDocumentoDiferenteSiMismo(String numeroDocumento, int idProveedor);
	
	
	@Query("SELECT e FROM Proveedor e WHERE e.nombreProveedor = ?1 AND e.idProveedor != ?2 ")
	public List<Proveedor> listaPorNombreDiferenteSiMismoActualiza(String nombreProveedor, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.correo = ?1 AND e.idProveedor != ?2 ")
	public List<Proveedor> listaPorCorreoDiferenteSiMismoActualiza(String correo, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.telefono = ?1 AND e.idProveedor != ?2 ")
	public List<Proveedor> listaPorTelefonoDiferenteSiMismoActualiza(String telefono, int idProveedor);
	@Query("SELECT e FROM Proveedor e WHERE e.telefonoContacto = ?1 AND e.idProveedor <> ?2 ")
	public List<Proveedor> listaPorTelefonoContactoDiferenteSiMismoActualiza(String telefonoContacto, int idProveedor);
	@Query("select e from Proveedor e where e.numeroDocumento = ?1 and e.idProveedor!= ?2 ")
	public List<Proveedor> listaPornumeroDocumentoDiferenteSiMismoActualiza(String numeroDocumento, int idProveedor);

}
