package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;

import java.util.List;

public interface ArticuloService {
    List<Articulo> listItemsBySupplierName(String nombreProveedor);

    List<Articulo> searchItemsByCategoryDescription(String descripcion);

    public List<Articulo> listarArticulos();

    public void guardar(Articulo articulo);

    public Articulo encontrarArticulo(Articulo articulo);

    public List<Articulo> listarArticulosConStockBajo();

    public void eliminar(Long iden);

    public Articulo obtenerArticuloPorId(Long id);

    Articulo findByCode(String codigo);
}
