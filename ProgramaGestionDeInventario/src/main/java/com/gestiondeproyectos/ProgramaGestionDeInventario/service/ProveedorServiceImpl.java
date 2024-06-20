package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ProveedorDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorDao proveedorDao;

    @Autowired
    public ProveedorServiceImpl(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorDao.findAll();
    }
}
