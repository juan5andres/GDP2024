package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ProveedorService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

@Controller
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

}
