package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.RolService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

@Controller
public class RolController {
    
    @Autowired
    private RolService rolService;

}
