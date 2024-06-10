package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByNombre(String username);

    @Query(value = "SELECT * FROM usuario u ORDER BY u.nombre ASC", nativeQuery = true)
    List<Usuario> listarUsuarios();
}
