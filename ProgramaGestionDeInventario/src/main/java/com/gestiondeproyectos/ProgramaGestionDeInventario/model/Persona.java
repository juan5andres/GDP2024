package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "Email", length = 50, nullable = false)
    private String email;

    @Column(name = "Telefono", length = 50, nullable = false)
    private String telefono;

    @Column(name = "Domicilio", length = 50, nullable = false)
    private String domicilio;

    public Persona(Long iden, String nombre, String apellido, String email, String telefono, String domicilio) {
        this.iden = iden;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }
    public Persona() {}

}