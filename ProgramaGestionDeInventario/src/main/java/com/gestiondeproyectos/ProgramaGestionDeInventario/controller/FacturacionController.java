package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacturacionController {

    @GetMapping("/facturacion")
    public String facturacion() {
        return "facturacion";
    }

    @GetMapping("/reportes")
    public String reportes() {
        return "reportes";
    }
}