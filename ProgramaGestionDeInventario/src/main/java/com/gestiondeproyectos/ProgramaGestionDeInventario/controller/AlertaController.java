package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ArticuloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlertaController {

    @Autowired
    private ArticuloServiceImpl articuloServiceImpl;

    @GetMapping("/alertas")
    public Map<String, List<Articulo>> getAlertas() {
        Map<String, List<Articulo>> alertas = new HashMap<>();
        alertas.put("lowStock", articuloServiceImpl.listarArticulosConStockBajo());
        alertas.put("expiring", articuloServiceImpl.listarArticulosVencidosOPorVencer());
        return alertas;
    }
}