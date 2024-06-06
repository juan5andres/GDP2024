package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Telefono", length = 20, nullable = false)
    private String telefono;

    @Column(name = "Domicilio", length = 200, nullable = false)
    private String domicilio;

    @ManyToOne
    @JoinColumn(name = "Persona_De_Contacto", nullable = false)
    private Persona personaDeContacto;

    @Column(name = "Forma_De_Pago", length = 100, nullable = false)
    private String formaDePago;

    @Column(name = "Cuit", length = 20, nullable = false)
    private String cuit;

    @Column(name = "Baja", nullable = false)
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