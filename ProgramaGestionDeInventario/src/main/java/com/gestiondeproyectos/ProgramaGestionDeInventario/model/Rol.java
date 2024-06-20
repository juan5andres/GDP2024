package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Rol() {}

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }
}
