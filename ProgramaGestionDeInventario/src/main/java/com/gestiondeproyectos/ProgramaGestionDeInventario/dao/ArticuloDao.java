package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticuloDao extends JpaRepository<Articulo, Long>{

    @Query(value = "SELECT * FROM articulo a ORDER BY a.nombre ASC", nativeQuery = true)
    List<Articulo> listItems();
    
    @Query(value = "SELECT a.*, c.descripcion AS categoria_descripcion FROM Articulo a " + 
                "JOIN CategoriaPorArticulo cpa ON a.iden = cpa.articulo_iden " + 
                "JOIN Categoria c ON cpa.categoria_iden = c.iden " + 
                "ORDER BY c.iden ASC, a.nombre ASC; ", nativeQuery = true)
    List<Articulo> listItemsByCategory();

    @Query(value = "SELECT a.*, p.nombre AS nombre_proveedor, p.email AS email_proveedor FROM Articulo a " + 
                "JOIN CategoriaPorArticulo cpa ON a.iden = cpa.articulo_iden " + 
                "JOIN Categoria c ON cpa.categoria_iden = c.iden " + 
                "JOIN categoriaporproveedor cpp ON c.iden = cpp.categoria_iden " +
                "JOIN proveedor p ON cpp.categoria_iden = p.iden " +
                "ORDER BY p.iden ASC, a.nombre ASC; ", nativeQuery = true)
    List<Articulo> listItemsBySupplier();

    @Query("SELECT a FROM Articulo a " +
           "JOIN CategoriaPorArticulo cpa ON a.iden = cpa.articulo_iden " +
           "JOIN Categoria c ON cpa.categoria_iden = c.iden " +
           "WHERE a.descripcion LIKE %:descripcion% " +
           "ORDER BY a.nombre ASC")
    List<Articulo> listItemsByCategoryDescription(
            @Param("descripcion") String descripcion);

    @Query("SELECT a FROM Articulo a " +
           "JOIN CategoriaPorArticulo cpa ON a.iden = cpa.articulo_iden " +
           "JOIN CategoriaPorProveedor cpp ON cpa.categoria_iden = cpp.categoria_iden " +
           "JOIN Proveedor p ON cpp.proveedor_iden = p.iden " +
           "WHERE p.nombre LIKE %:nombreProveedor% " +
           "ORDER BY a.nombre ASC")
    List<Articulo> listItemsBySupplierName(
            @Param("nombreProveedor") String nombreProveedor);
    
    @Query("SELECT a FROM Articulo a " +
           "WHERE a.nombre LIKE %:nombre% " +
           "ORDER BY a.nombre ASC")
    List<Articulo> listItemsByName(@Param("nombre") String nombre);

    @Query("SELECT a FROM Articulo a " +
           "WHERE a.codigo = :Iden " +
           "ORDER BY a.nombre ASC")
    List<Articulo> listItemsByIden(@Param("Iden") String Iden);

}
