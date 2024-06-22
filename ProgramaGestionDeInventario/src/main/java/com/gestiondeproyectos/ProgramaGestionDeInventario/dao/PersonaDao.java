package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    Persona findByIden(Long iden);
}
