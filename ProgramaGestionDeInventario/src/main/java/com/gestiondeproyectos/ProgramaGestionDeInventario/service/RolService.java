package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import java.util.List;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

public interface RolService{

    public void guardar(Rol rol);

    public List<Rol> listarRoles();
    
}