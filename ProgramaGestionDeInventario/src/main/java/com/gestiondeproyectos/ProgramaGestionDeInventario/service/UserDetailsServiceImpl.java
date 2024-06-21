package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.UsuarioDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    @Autowired
    public UserDetailsServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByNombre(username);
        if (usuario == null) {
            usuario = usuarioDao.findByEmail(username);
            if (usuario == null) {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }
        }

        return new User(
                usuario.getNombre(),
                usuario.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(usuario.getRol().getDescripcion())));
    }
}
