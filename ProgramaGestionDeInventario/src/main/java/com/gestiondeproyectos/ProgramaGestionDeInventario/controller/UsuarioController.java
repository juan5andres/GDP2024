package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import java.util.Arrays;
import java.util.List;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.*;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }

    /*@GetMapping("/crearUsuario")
    public String crearUsuario(Model model){
        List<Rol> roles = rolService.listarRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String guardarUsuario(Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/listarUsuarios";
    }*/
        
    @GetMapping("/crearUsuarioConPermisos")
    public String crearUsuario(Model model, Authentication authentication){
        Usuario sessionUser =(Usuario) authentication.getPrincipal();
        if(sessionUser.getRol().getDescripcion().equals("Usuario")){
            return "redirect:/listarUsuarios";
        }
        List<RolEnum> roles = Arrays.asList(RolEnum.values());
        model.addAttribute("roles", roles);
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model){
        List<RolEnum> roles = Arrays.asList(RolEnum.values());
        model.addAttribute("roles", roles);
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String guardarUsuario(Usuario usuario){
        // Aquí asignas el rol al usuario basado en el valor seleccionado del enum
        usuario.setRol(usuario.getRol());
        usuarioService.guardar(usuario);
        return "redirect:/listarUsuarios";
    }

}
