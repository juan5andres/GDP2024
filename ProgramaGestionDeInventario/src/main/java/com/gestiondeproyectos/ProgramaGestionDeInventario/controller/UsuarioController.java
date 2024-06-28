package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import java.util.List;

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
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

}
