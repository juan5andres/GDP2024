package com.gestiondeproyectos.ProgramaGestionDeInventario.service.Alerta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ArticuloServiceImpl;

@Service
public class AlertaServiceImpl implements AlertaService {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ArticuloServiceImpl articuloServiceImpl;

    @Override
    @Scheduled(cron = "0 0 0 * * ?") 
    public void checkLowStock() {
        List<Articulo> lowStockItems = articuloServiceImpl.listarArticulosConStockBajo();
        if (!lowStockItems.isEmpty()) {
            notificationService.sendLowStockNotification(lowStockItems);
        }
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?") 
    public void checkExpiringItems() {
        List<Articulo> expiringItems = articuloServiceImpl.listarArticulosVencidosOPorVencer();
        if (!expiringItems.isEmpty()) {
            notificationService.sendExpirationNotification(expiringItems);
        }
    }
}