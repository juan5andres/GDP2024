package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.RolService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

@Controller
public class RolController {
    
    @Autowired
    private RolService rolService;

    @PostMapping("/guardarRol")
    public String guardarRol(Rol rol) {
        rolService.guardar(rol);
        return "redirect:/";
    }

    @GetMapping("/listarRoles")
    public String listarRoles(Model model) {
        if (rolService.listarRoles().isEmpty()){
            Rol admin = new Rol();
            admin.setDescripcion("ADMIN");
            guardarRol(admin);
            Rol user = new Rol();
            user.setDescripcion("USER");
            guardarRol(user);
            var roles = rolService.listarRoles();
            model.addAttribute("roles", roles);
            return "listarRoles";
        }
        else{
            var roles = rolService.listarRoles();
            model.addAttribute("roles", roles);
            return "listarRoles";
        }
    }
}