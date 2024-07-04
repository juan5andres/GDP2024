package com.gestiondeproyectos.ProgramaGestionDeInventario.service.Alerta;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import java.util.List;

public interface NotificationService {
    void sendLowStockNotification(List<Articulo> lowStockItems);
    void sendExpirationNotification(List<Articulo> expiringItems);
}