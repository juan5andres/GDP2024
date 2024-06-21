package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "domicilio", nullable = false)
    private String domicilio;

    @Column(name = "persona_de_contacto", nullable = false)
    private Long personaDeContacto;

    @Column(name = "forma_de_pago", nullable = false)
    private String formaDePago;

    @Column(name = "cuit", nullable = false)
    private String cuit;

    @Column(name = "baja", nullable = false)
    private Boolean baja;
}
