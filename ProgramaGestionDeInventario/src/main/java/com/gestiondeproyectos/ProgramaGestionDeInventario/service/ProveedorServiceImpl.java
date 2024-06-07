package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ProveedorDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    
    @Autowired
    private ProveedorDao proveedorDao;

}
