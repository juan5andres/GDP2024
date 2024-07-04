package com.gestiondeproyectos.ProgramaGestionDeInventario.service.Alerta;

import org.springframework.stereotype.Service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendLowStockNotification(List<Articulo> lowStockItems) {
        // Implementar lógica para enviar notificación de bajo stock
    }

    @Override
    public void sendExpirationNotification(List<Articulo> expiringItems) {
        // Implementar lógica para enviar notificación de vencimiento
    }
}