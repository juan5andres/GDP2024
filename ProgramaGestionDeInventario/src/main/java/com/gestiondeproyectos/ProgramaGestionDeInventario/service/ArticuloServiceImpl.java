package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    private ArticuloDao articuloDao;

}
