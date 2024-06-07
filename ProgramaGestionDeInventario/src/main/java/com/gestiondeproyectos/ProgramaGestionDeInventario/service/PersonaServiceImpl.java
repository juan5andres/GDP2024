package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.PersonaDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;

}
