package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String descripcion;

    public Categoria(Long iden, String descripcion) {
        this.iden = iden;
        this.descripcion = descripcion;
    }

    public Categoria() {}
}