package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloDao articuloDao;

    @Autowired
    public ArticuloServiceImpl(ArticuloDao articuloDao) {
        this.articuloDao = articuloDao;
    }

    @Override
    @Transactional
    public List<Articulo> listarArticulos() {
        return articuloDao.listItems();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> listarArticulosConStockBajo(){
        var listadoArticulos = listarArticulos();
        List<Articulo> articulosConStockBajo = new ArrayList<Articulo>();
        for (Articulo a : listadoArticulos) {
            if(a.getCantidadMinima()>a.getStock()){
                articulosConStockBajo.add(a);
            }
        }
        return articulosConStockBajo;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> listItemsBySupplierName(String nombreProveedor) {
        return articuloDao.listItemsBySupplierName(nombreProveedor);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> searchItemsByCategoryDescription(String descripcion) {
        return articuloDao.listItemsByCategoryDescription(descripcion);
    }

    @Override
    @Transactional
    public void guardar(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo encontrarArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIden()).orElse(null); 
    }

    @Override
    @Transactional
    public void eliminar(Articulo articulo) {
        articuloDao.delete(articulo);
    }  
}
