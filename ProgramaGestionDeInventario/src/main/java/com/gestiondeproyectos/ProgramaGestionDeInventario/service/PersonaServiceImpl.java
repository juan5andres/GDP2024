package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.PersonaDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class PersonaServiceImpl implements PersonaService{
    
    /*@Autowired
    private PersonaDao personaDao;

    @Autowired
    private ProveedorService proveedorService;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas(){
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona){
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona){
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIden()).orElse(null); 
    }

    @Override
    @Transactional(readOnly=true)
    public boolean personaNoVinculada(Persona persona) {
        var listaDeProveedores = proveedorService.searchProvidersByPerson(persona.getIden());
        if (listaDeProveedores.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }*/

}
