package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {

    @Query("SELECT a FROM Articulo a WHERE a.proveedor.nombre = :nombreProveedor")
    List<Articulo> listItemsBySupplierName(@Param("nombreProveedor") String nombreProveedor);

    @Query("SELECT a FROM Articulo a WHERE a.categoria.iden = :categoriaId")
    List<Articulo> findByCategoriaId(@Param("categoriaId") Long categoriaId);

    @Query("SELECT a FROM Articulo a WHERE a.proveedor.iden = :proveedorId")
    List<Articulo> findByProveedorId(@Param("proveedorId") Long proveedorId);

    /*@Query(value = "SELECT * FROM articulo a " +
            "JOIN categoria_por_articulo cpa ON a.iden = cpa.articulo_iden " +
            "JOIN categoria c ON cpa.categoria_iden = c.iden " +
            "WHERE lower(a.descripcion) LIKE lower(CONCAT('%', ?1, '%')) " +
            "ORDER BY a.nombre ASC", nativeQuery = true)
    List<Articulo> listItemsByCategoryDescription(String keyword);*/

    @Query(value = "SELECT a.iden AS articulo_iden, a.nombre AS articulo_nombre, c.descripcion AS categoria_descripcion, c.iden AS categoria_iden " +
            "FROM articulo a " +
            "JOIN categoria c ON a.categoria_id = c.iden " +
            "WHERE c.descripcion = :descripcion", nativeQuery = true)
    List<Articulo> listItemsByCategoryDescription(@Param("descripcion") String descripcion);



    /*@Query(value = "SELECT a.*, c.descripcion AS categoria_descripcion, (a.stock * a.precio_unitario) AS producto_precio_Total FROM articulo a " +
            "JOIN categoria_por_articulo cpa ON a.iden = cpa.articulo_iden " +
            "JOIN categoria c ON cpa.categoria_iden = c.iden " +
            "ORDER BY a.nombre ASC", nativeQuery = true)
    List<Articulo> listItems();*/
    
    Articulo findByIden(Long iden);
}
