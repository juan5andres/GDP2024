package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.*;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model, Authentication authentication){
        String name = ((UserDetails) authentication.getPrincipal()).getUsername();
        String email = (usuarioService.findByUsername(name)).get().getEmail();
        Optional<Usuario> optionalSessionUser = Optional.ofNullable(usuarioService.findByEmail(email));

        if (optionalSessionUser.isPresent()) {
            Usuario sessionUser = optionalSessionUser.get();
            if ("Usuario".equals(sessionUser.getRol().getDescripcion())) {
                return "redirect:/listarUsuarios";
            }
        }

        List<RolEnum> roles = Arrays.asList(RolEnum.values());
        model.addAttribute("roles", roles);
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String guardarUsuario(Usuario usuario){
        usuario.setRol(usuario.getRol());
        usuarioService.guardar(usuario);
        return "redirect:/listarUsuarios";
    }

    @PostMapping("/eliminarUsuario/{iden}")
    public String eliminarUsuario(@PathVariable Long iden, Authentication authentication) {
        String name = ((UserDetails) authentication.getPrincipal()).getUsername();
        String email = (usuarioService.findByUsername(name)).get().getEmail();
        Optional<Usuario> optionalSessionUser = Optional.ofNullable(usuarioService.findByEmail(email));

        if (optionalSessionUser.isPresent()) {
            Usuario sessionUser = optionalSessionUser.get();
            if (!"Administrador".equals(sessionUser.getRol().getDescripcion())) {
                // Si el usuario no es administrador, redirigir a la lista de usuarios sin eliminar
                return "redirect:/listarUsuarios";
            }
        }

        usuarioService.eliminar(iden);
        return "redirect:/listarUsuarios";
    }
}
