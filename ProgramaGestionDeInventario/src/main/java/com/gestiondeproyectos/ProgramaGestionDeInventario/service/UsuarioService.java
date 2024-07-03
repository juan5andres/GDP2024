package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    //void saveUser(Usuario user, int roleId);

    //void saveAdmin(Usuario user);
    //void saveRegularUser(Usuario user);
    Optional<Usuario> findByUsername(String username);
    void guardar(Usuario user);
    public List<Usuario> listarUsuarios();
    public Usuario findByEmail(String email);
    void updatePassword(String updatedPassword, Long iden);
}