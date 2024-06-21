package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "precio_Unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "fecha_Vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "unidad_De_Referencia", nullable = false)
    private String unidadDeReferencia;

    @Column(name = "cantidad_Minima", nullable = false)
    private int cantidadMinima;

    @Column(name = "codigo_Producto", nullable = false)
    private String codigoProducto;

    public Articulo(Long iden, String nombre, int stock, double precioUnitario, Date fechaVencimiento, String unidadDeReferencia, int cantidadMinima, String codigoProducto) {
        this.id = iden;
        this.nombre = nombre;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.fechaVencimiento = fechaVencimiento;
        this.unidadDeReferencia = unidadDeReferencia;
        this.cantidadMinima = cantidadMinima;
        this.codigoProducto = codigoProducto;
    }
    public Articulo() {}

}