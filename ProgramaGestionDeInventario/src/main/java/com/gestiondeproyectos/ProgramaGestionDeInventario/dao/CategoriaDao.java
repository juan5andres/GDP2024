package com.gestiondeproyectos.ProgramaGestionDeInventario.dao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
    public Categoria findByIden(Long iden);

}
