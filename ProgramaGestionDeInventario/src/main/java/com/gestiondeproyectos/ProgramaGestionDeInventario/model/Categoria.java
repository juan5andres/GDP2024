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

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria() {}

    public Long getIden() {
        return iden;
    }

    public void setIden(Long iden) {
        this.iden = iden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
