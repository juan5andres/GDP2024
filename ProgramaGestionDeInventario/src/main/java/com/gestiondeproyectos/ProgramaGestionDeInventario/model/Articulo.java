package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;


@Data
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "Stock", nullable = false)
    private int stock;

    @Column(name = "Precio_Unitario", precision = 10, scale = 2, nullable = false)
    private double precioUnitario;

    @Column(name = "Fecha_Vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "Unidad_De_Referencia", length = 50, nullable = false)
    private String unidadDeReferencia;

    @Column(name = "Cantidad_Minima", nullable = false)
    private int cantidadMinima;

    @Column(name = "Codigo_Producto", length = 50, nullable = false)
    private String codigoProducto;

    public Articulo(Long iden, String nombre, int stock, double precioUnitario, Date fechaVencimiento, String unidadDeReferencia, int cantidadMinima, String codigoProducto) {
        this.iden = iden;
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