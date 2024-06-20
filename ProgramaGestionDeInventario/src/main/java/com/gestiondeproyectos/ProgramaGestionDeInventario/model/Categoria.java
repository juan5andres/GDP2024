package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<CategoriaPorArticulo> categoriasPorArticulo;

    public Categoria(Long iden, String descripcion) {
        this.iden = iden;
        this.descripcion = descripcion;
    }

    public Categoria() {}
}
