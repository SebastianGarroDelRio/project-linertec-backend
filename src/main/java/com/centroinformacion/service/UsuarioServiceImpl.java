package com.centroinformacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Opcion;
import com.centroinformacion.entity.Rol;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario login(Usuario bean) {
        return repository.login(bean);
    }

    @Override
    public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
        return repository.traerEnlacesDeUsuario(idUsuario);
    }

    @Override
    public List<Rol> traerRolesDeUsuario(int idUsuario) {
        return repository.traerRolesDeUsuario(idUsuario);
    }

    @Override
    public List<Usuario> buscaPorLogin(String login) {
        return repository.findByLoginIgnoreCase(login);
    }

    //CRUD
    @Override
    public List<Usuario> listaTodos() {
        return repository.findAll();
    }

    @Override
    public List<Usuario> listaPorNombreUsuarioLike(String filtro) {
        return repository.listaUsuarioNombreLike(filtro);
    }

    @Override
    public Usuario insertaActualizaUsuario(Usuario obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaUsuarioPorId(int idUsuario) {
        repository.deleteById(idUsuario);
    }

    @Override
    public Optional<Usuario> listaUsuarioPorId(int idUsuario) {
        return repository.findById(idUsuario);
    }

    //VALIDACIONES
    @Override
    public List<Usuario> listaUsuarioPorDniDiferenteSiMismo(String dni, int idUsuario) {
        return repository.listaPorDniDiferenteSiMismo(dni, idUsuario);
    }

    @Override
    public List<Usuario> listaUsuarioPorCorreoDiferenteSiMismo(String correo, int idUsuario) {
        return repository.listaPorCorreoDiferenteSiMismo(correo, idUsuario);
    }

    @Override
    public List<Usuario> listarPorCorreo(String correo) {
        return repository.findByCorreoIgnoreCase(correo);
    }

    @Override
    public List<Usuario> listaUsuarioPorLoginDiferenteSiMismo(String login, int idUsuario) {
        return repository.listaPorLoginDiferenteSiMismo(login, idUsuario);
    }

    @Override
    public List<Usuario> listaUsuarioPorDniDiferenteSiMismoActualiza(String dni, int idUsuario) {
        return repository.listaPorDniDiferenteSiMismoActualiza(dni, idUsuario);
    }

    @Override
    public List<Usuario> listaUsuarioPorLoginDiferenteSiMismoActualiza(String login, int idUsuario) {
        return repository.listaPorLoginDiferenteSiMismoActualiza(login, idUsuario);
    }

    @Override
    public List<Usuario> listaUsuarioPorCorreoDiferenteSiMismoActualiza(String correo, int idUsuario) {
        return repository.listaPorCorreoDiferenteSiMismoActualiza(correo, idUsuario);
    }


}
