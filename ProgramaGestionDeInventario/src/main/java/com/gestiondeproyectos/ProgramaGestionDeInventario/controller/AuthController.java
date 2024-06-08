package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    @Autowired
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String registerUsuario(Usuario user) {
        usuarioService.saveRegularUser(user);
        return "redirect:/login";
    }

    @GetMapping("/admin/register")
    public String registerAdmin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin_register";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(Usuario usuario) {
        usuarioService.saveRegularUser(usuario);
        return "redirect:/admin/dashboard";
    }
}
