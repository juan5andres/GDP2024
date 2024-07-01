package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.UsuarioDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.RolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final RolDao rolDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao, RolDao rolDao, PasswordEncoder passwordEncoder) {
        this.usuarioDao = usuarioDao;
        this.rolDao = rolDao;
        this.passwordEncoder = passwordEncoder;
    }


    /*@Override
    public void saveUser(Usuario user, int roleId) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol(rolDao.findRolByIden(roleId));
        usuarioDao.save(user);
    }

    @Override
    public void saveAdmin(Usuario user) {
        saveUser(user, 1);
    }

    @Override
    public void saveRegularUser(Usuario user) {
        saveUser(user, 2);
    }*/

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.ofNullable(usuarioDao.findByNombre(username));
    }

    @Override
    public void guardar(Usuario user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usuarioDao.save(user);
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioDao.listarUsuarios();
    }
}
