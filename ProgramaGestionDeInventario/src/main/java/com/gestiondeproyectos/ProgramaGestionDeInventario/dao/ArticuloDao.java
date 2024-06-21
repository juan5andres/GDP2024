package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {

    @Query("SELECT a FROM Articulo a WHERE a.proveedor.nombre = :nombreProveedor")
    List<Articulo> listItemsBySupplierName(@Param("nombreProveedor") String nombreProveedor);
}
