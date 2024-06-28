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
    private Long iden;

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

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(name = "precio_Total", nullable = false)
    private double precioTotal;


    public Articulo(String nombre, int stock, double precioUnitario, Date fechaVencimiento, String unidadDeReferencia, int cantidadMinima, String codigoProducto, Categoria categoria) {
        this.nombre = nombre;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.fechaVencimiento = fechaVencimiento;
        this.unidadDeReferencia = unidadDeReferencia;
        this.cantidadMinima = cantidadMinima;
        this.codigoProducto = codigoProducto;
        this.categoria = categoria;
    }

    public Articulo() {}

    public Long getIden() {
        return iden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getUnidadDeReferencia() {
        return unidadDeReferencia;
    }

    public void setUnidadDeReferencia(String unidadDeReferencia) {
        this.unidadDeReferencia = unidadDeReferencia;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
