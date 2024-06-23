package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ProveedorDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorDao proveedorDao;

    @Autowired
    public ProveedorServiceImpl(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    @Override
    @Transactional
    public List<Proveedor> listarProveedores() {
        return proveedorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> searchProvidersByCategoryDescription(String descripcion) {
      return proveedorDao.listProvidersByCategoryDescription(descripcion);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Proveedor> searchProvidersByPerson(Long iden) {
      return proveedorDao.listProvidersByPerson(iden);
    }

    @Override
    @Transactional(readOnly=true)
    public Proveedor encontrarProveedor(Proveedor proveedor) {
      return proveedorDao.findByIden(proveedor.getIden()); 
    }

    @Override
    @Transactional
    public void guardar(Proveedor proveedor) {
      proveedorDao.save(proveedor);
    }
}
