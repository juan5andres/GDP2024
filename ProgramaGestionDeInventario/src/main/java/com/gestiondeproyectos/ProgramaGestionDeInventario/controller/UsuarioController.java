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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String listarUsuarios(Model model, Authentication authentication) {
        String name = ((UserDetails) authentication.getPrincipal()).getUsername();
        String email = (usuarioService.findByUsername(name)).getEmail();
        Optional<Usuario> optionalSessionUser = Optional.ofNullable(usuarioService.findByEmail(email));
        if (optionalSessionUser.isPresent()) {
            Usuario sessionUser = optionalSessionUser.get();
            if ("Usuario".equals(sessionUser.getRol().getDescripcion())) {
                Usuario usuario = usuarioService.findByEmail(email);
                model.addAttribute("usuario", usuario);
                return "listarUsuarioPropio";
            }
        }
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
        Usuario usuarioAux = usuarioService.findByEmail(usuario.getEmail());
        if (usuarioAux==null){
            usuarioAux = usuarioService.findByUsername(usuario.getNombre());
            if (usuarioAux!=null && !usuarioAux.getIden().equals(usuario.getIden()) && usuarioAux.getNombre().equals(usuario.getNombre())){
                return "crearUsuario";
            }
        }else{
            if(!usuarioAux.getIden().equals(usuario.getIden()) && usuarioAux.getEmail().equals(usuario.getEmail())){
                return "crearUsuario";
            }
        }
        usuario.setRol(usuario.getRol());
        usuarioService.guardar(usuario);
        return "redirect:/listarUsuarios";
    }

    @PostMapping("/eliminarUsuario/{iden}")
    public String eliminarUsuario(@PathVariable Long iden) {
        usuarioService.eliminar(iden);
        return "redirect:/listarUsuarios";
    }

    @GetMapping("/editarUsuario/{iden}")
    public String mostrarFormularioEditarUsuario(@PathVariable("iden") Long iden, Model model) {
        Usuario usuario = usuarioService.findByIden(iden);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("action", "editar");
            return "editarUsuario";
        }
        return "redirect:/listarUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario);
            return "editarUsuario";
        }
        if (usuario.getIden() == null) {
            model.addAttribute("error", "ID del usuario no puede ser null");
            return "editarUsuario";
        }
        Usuario existingUsuario = usuarioService.findByIden(usuario.getIden());
        if (existingUsuario != null) {
            usuario.setPassword(existingUsuario.getPassword());
            usuario.setRol(existingUsuario.getRol());
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "redirect:/index";
        }
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/listarUsuarios";
    }
    
}
