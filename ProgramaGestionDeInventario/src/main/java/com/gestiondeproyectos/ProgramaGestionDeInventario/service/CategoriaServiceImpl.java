package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.CategoriaDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;
}
