package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoriaPorArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @ManyToOne
    @JoinColumn(name = "Articulo_Iden", nullable = false)
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "Categoria_Iden", nullable = false)
    private Categoria categoria;

    public CategoriaPorArticulo(Long iden, Articulo articulo, Categoria categoria) {
        this.iden = iden;
        this.articulo = articulo;
        this.categoria = categoria;
    }

    public CategoriaPorArticulo() {
    }
}