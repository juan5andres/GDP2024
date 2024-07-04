package com.gestiondeproyectos.ProgramaGestionDeInventario.service.Alerta;

public interface AlertaService {
    void checkLowStock();
    void checkExpiringItems();
}