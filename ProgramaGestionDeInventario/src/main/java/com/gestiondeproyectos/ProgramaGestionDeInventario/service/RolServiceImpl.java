package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.RolDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;

}
