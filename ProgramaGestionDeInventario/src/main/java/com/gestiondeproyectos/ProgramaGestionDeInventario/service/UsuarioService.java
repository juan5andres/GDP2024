package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    void saveUser(Usuario user, int roleId);

    void saveAdmin(Usuario user);
    void saveRegularUser(Usuario user);
    Optional<Usuario> findByUsername(String username);

}
