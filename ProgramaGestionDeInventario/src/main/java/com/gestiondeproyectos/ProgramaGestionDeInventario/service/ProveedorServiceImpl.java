package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ProveedorDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorDao proveedorDao;

    private final ArticuloDao articuloDao;

    @Autowired
    public ProveedorServiceImpl(ProveedorDao proveedorDao, ArticuloDao articuloDao ) {
        this.proveedorDao = proveedorDao;
        this.articuloDao = articuloDao;
    }

    @Override
    @Transactional
    public List<Proveedor> listarProveedores() {
        return proveedorDao.listarProveedores();
    }

    @Override
    public Proveedor findByName(String nombre) {
        return proveedorDao.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> searchProvidersByCategoryDescription(String descripcion) {
      return proveedorDao.listProvidersByCategoryDescription(descripcion);
    }

    @Override
    @Transactional(readOnly=true)
    public Proveedor encontrarProveedor(Proveedor proveedor) {
      return proveedorDao.findById(proveedor.getIden()).orElse(null); 
    }

    @Override
    @Transactional
    public void guardar(Proveedor proveedor) {
      proveedorDao.save(proveedor);
    }

    @Override
    @Transactional
    public void darDeBaja(Long iden) {
      Proveedor proveedor = proveedorDao.findByIden(iden);
      Boolean estado = proveedor.getBaja();
      estado = !estado;
      proveedorDao.darDeBaja(estado, proveedor.getIden());
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarProveedor(Long iden) {
      Proveedor proveedor = proveedorDao.findByIden(iden);
        if (proveedorNoVinculado(proveedor)) {
            proveedorDao.delete(proveedor);
        } else {
            throw new IllegalStateException("El proveedor está vinculado a artículos y no puede ser eliminado.");
        }
    }

    @Override
    @Transactional(readOnly=true)
    public boolean proveedorNoVinculado(Proveedor proveedor) {
        var listaDeArticulos = articuloDao.findByProveedorId(proveedor.getIden());
        return listaDeArticulos.isEmpty();
    }
}