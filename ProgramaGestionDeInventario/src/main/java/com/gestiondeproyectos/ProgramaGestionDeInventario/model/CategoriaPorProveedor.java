package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoriaPorProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @ManyToOne
    @JoinColumn(name = "proveedor_Iden", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "categoria_Iden", nullable = false)
    private Categoria categoria;

    public CategoriaPorProveedor(Long iden, Proveedor proveedor, Categoria categoria) {
        this.iden = iden;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public CategoriaPorProveedor() {}
}