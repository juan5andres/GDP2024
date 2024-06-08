package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.repository.RoleRepository;
import com.gestiondeproyectos.ProgramaGestionDeInventario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(Usuario user, int roleId) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol(roleRepository.findRolByIden(roleId));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(Usuario user) {
        saveUser(user, 1);
    }

    @Override
    public void saveRegularUser(Usuario user) {
        saveUser(user, 2);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByNombre(username));
    }
}
