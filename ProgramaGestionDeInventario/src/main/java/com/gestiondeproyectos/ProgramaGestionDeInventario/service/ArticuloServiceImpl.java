package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    private ArticuloDao articuloDao;

    public List<Articulo> searchItemsBySupplierName(String nombreProveedor) {
        return articuloDao.listItemsBySupplierName(nombreProveedor);
    }

    public List<Articulo> searchItems() {
        return articuloDao.listItems();
    }
    
    public List<Articulo> searchItemsByCategory() {
        return articuloDao.listItemsByCategory();
    }

    public List<Articulo> searchItemsBySupplier() {
        return articuloDao.listItemsBySupplier();
    }

    public List<Articulo> searchItemsByCategoryDescription(String descripcion) {
        return articuloDao.listItemsByCategoryDescription(descripcion);
    }

    public List<Articulo> searchItemsByName(String nombre) {
        return articuloDao.listItemsByName(nombre);
    }

    public List<Articulo> searchItemsByCode(String codigo) {
        return articuloDao.listItemsByIden(codigo);
    }

}
