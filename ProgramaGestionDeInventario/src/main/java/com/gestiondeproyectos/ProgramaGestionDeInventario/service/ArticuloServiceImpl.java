package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloDao articuloDao;

    @Autowired
    public ArticuloServiceImpl(ArticuloDao articuloDao) {
        this.articuloDao = articuloDao;
    }

    @Override
    public List<Articulo> listItemsBySupplierName(String nombreProveedor) {
        return articuloDao.listItemsBySupplierName(nombreProveedor);
    }

    public List<Articulo> searchItemsByCategoryDescription(String descripcion) {
        return articuloDao.listItemsByCategoryDescription(descripcion);
    }  
}
