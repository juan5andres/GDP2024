package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> listarProveedores();

    List<Proveedor> searchProvidersByCategoryDescription(String descripcion);

	List<Proveedor> searchProvidersByPerson(Long iden);

    Proveedor encontrarProveedor(Proveedor proveedor);

    void guardar(Proveedor proveedor);

    void eliminar(Proveedor proveedor);
}
