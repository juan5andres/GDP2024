package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import java.util.List;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Persona;

public interface PersonaService {


    public List<Persona> listarPersonas();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);

    public boolean personaNoVinculada(Persona persona);
    
}
