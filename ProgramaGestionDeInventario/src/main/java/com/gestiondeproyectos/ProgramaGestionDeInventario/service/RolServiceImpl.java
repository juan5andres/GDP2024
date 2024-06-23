package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.RolDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> listarRoles() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    @Transactional
    public void guardar (Rol rol) {
        rolDao.save(rol);
    }

}
