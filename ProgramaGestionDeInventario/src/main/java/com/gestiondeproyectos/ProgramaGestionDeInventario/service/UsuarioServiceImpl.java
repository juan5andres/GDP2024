package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.UsuarioDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
}
