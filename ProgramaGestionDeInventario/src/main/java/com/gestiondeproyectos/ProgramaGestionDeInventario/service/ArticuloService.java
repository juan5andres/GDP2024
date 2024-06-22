package com.gestiondeproyectos.ProgramaGestionDeInventario.service;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;

import java.util.List;

public interface ArticuloService {
    List<Articulo> listItemsBySupplierName(String nombreProveedor);

    List<Articulo> searchItemsByCategoryDescription(String descripcion);
}
