package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> listarProveedores();

    Proveedor findByName(String name);

    List<Proveedor> searchProvidersByCategoryDescription(String descripcion);

    Proveedor encontrarProveedor(Proveedor proveedor);

    void guardar(Proveedor proveedor);

    void darDeBaja(Long iden);

    public Proveedor obtenerProveedorPorId(Long id);

    void eliminarProveedor(Long iden);

    boolean proveedorNoVinculado(Proveedor proveedor);
}
