package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long>{
    Rol findRolByIden(int id);
}
