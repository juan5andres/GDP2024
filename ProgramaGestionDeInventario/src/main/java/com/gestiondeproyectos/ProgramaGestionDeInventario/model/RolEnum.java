package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

public enum RolEnum {
    ADMIN("Administrador"),
    USER("Usuario");

    private final String descripcion;

    RolEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}