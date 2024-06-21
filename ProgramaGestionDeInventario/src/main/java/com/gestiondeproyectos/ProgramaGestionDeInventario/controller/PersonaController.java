package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.PersonaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Persona;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

}