package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProveedorDao extends JpaRepository<Proveedor, Long> {

    @Query(value = "SELECT * FROM proveedor p " +
          "JOIN categoria_por_proveedor cpp ON p.iden = cpp.proveedor_iden " +
           "JOIN categoria c ON cpp.categoria_iden = c.iden " +
           "WHERE lower(p.descripcion) LIKE lower(CONCAT('%', ?1, '%')) " +
           "ORDER BY p.nombre ASC", nativeQuery = true)
    List<Proveedor>  listProvidersByCategoryDescription(String keyword);

    @Query(value = "SELECT * FROM proveedor p " + 
    "ORDER BY p.nombre ASC", nativeQuery=true)
    List<Proveedor> listarProveedores();

    Proveedor findByIden(Long iden);

    Proveedor findByNombre(String nombre);

    @Transactional
    @Modifying 
    @Query(value = "UPDATE proveedor SET baja = :estado WHERE iden = :userId", nativeQuery=true)
    void darDeBaja(@Param("estado") Boolean estado, @Param("userId") Long userId);

    


}
/*@Query(value = "SELECT * FROM proveedor p " +
        "WHERE p.persona_de_contacto = ?1", nativeQuery = true)
List<Proveedor> listProvidersByPerson(Long iden);*/