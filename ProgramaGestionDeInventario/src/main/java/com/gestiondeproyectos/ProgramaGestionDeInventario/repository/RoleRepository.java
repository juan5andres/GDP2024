package com.gestiondeproyectos.ProgramaGestionDeInventario.repository;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
    Rol findRolByIden(int id);
}
