package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> listarProveedores();

    Proveedor findByName(String name);

    List<Proveedor> searchProvidersByCategoryDescription(String descripcion);

    Proveedor encontrarProveedor(Proveedor proveedor);

    void guardar(Proveedor proveedor);

    void eliminar(Long iden);

    public Proveedor obtenerProveedorPorId(Long id);
}
