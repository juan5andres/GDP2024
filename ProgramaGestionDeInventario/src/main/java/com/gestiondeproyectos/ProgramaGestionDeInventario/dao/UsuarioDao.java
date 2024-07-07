package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.PasswordResetToken;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
    
    @Query(value = "SELECT * FROM usuario u ORDER BY u.nombre ASC", nativeQuery = true)
    List<Usuario> listarUsuarios();

    @Query(value = "SELECT * FROM usuario u WHERE u.email = :email", nativeQuery = true)
    Usuario findByEmail(@Param("email") String email);

    @Transactional
    @Modifying 
    @Query(value = "UPDATE usuario set password = :updatedPassword WHERE iden = :userId", nativeQuery = true)
    void updatePassword(@Param("updatedPassword") String updatedPassword, @Param("userId") Long userId);

    Usuario findByIden(Long iden);

    @Query("SELECT t FROM PasswordResetToken t WHERE t.user.iden = :userId")
    PasswordResetToken recuperarToken(@Param("userId") Long userId);
}
