package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ArticuloService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;

@Controller
public class ArticuloController{
    
    @Autowired
    private ArticuloService articuloService;

}