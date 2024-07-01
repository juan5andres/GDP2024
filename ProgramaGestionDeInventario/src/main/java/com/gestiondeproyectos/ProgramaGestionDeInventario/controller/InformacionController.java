package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InformacionController {

    @GetMapping("/manual")
    public String manualController() {
        return "manual";
    }

    @GetMapping("/nosotros")
    public String nosotrosController() {
        return "nosotros";
    }
}