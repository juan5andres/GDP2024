package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model modelUsuarios){
        var usuarios = usuarioService.listarUsuarios();
        modelUsuarios.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

}
