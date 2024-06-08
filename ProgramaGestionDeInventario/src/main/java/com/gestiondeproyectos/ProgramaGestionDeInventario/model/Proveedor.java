package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

    @ManyToOne
    @JoinColumn(name = "persona_De_Contacto", nullable = false)
    private Persona personaDeContacto;

    @Column(name = "forma_De_Pago", nullable = false)
    private String formaDePago;

    @Column(name = "cuit", nullable = false)
    private String cuit;

    @Column(name = "baja", nullable = false)
    private boolean baja;

    public Proveedor(Long iden, String nombre, String email, String telefono, String domicilio, Persona personaDeContacto, String formaDePago, String cuit, boolean baja) {
        this.iden = iden;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.personaDeContacto = personaDeContacto;
        this.formaDePago = formaDePago;
        this.cuit = cuit;
        this.baja = baja;
    }
    public Proveedor() {}
}