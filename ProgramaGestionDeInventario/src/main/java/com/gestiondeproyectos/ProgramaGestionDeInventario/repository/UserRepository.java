package com.gestiondeproyectos.ProgramaGestionDeInventario.repository;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String username);
}
