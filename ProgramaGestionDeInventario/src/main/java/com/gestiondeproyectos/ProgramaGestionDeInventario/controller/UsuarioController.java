package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService UsuarioService;

}
