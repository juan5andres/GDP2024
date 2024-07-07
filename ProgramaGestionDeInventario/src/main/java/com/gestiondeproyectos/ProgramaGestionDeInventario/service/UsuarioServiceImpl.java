package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.UsuarioDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.PasswordResetToken;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.RolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Usuario findByUsername(String username) {
        return usuarioDao.findByNombre(username);
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
    public Usuario findByEmail(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    public void updatePassword(String updatedPassword, Long iden) {
        usuarioDao.updatePassword(updatedPassword, iden);
    }

    @Override
    @Transactional
    public void eliminar(Long iden) {
        Usuario usuario = usuarioDao.findByIden(iden);
        usuarioDao.delete(usuario);
    }  

    @Override
    public Usuario findByIden(Long iden){
        return usuarioDao.findById(iden).orElse(null);
    }

    @Override
    public void actualizarUsuario(Usuario user) {
        usuarioDao.save(user);
    }
    @Override
    public PasswordResetToken recuperarToken(Usuario user){
        Long userId = user.getIden();
        return usuarioDao.recuperarToken(userId);
    }
}
