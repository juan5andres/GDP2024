package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String descripcion;

    public Rol(Long iden, String descripcion) {
        this.iden = iden;
        this.descripcion = descripcion;
    }
    public Rol() {}
}