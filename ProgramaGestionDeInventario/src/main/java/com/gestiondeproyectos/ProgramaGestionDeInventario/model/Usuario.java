package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Telefono", length = 20, nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "Rol_Iden", nullable = false)
    private Rol rol;

    @Column(name = "Domicilio", length = 200, nullable = false)
    private String domicilio;

    public Usuario(Long iden, String nombre, String email, String telefono, Rol rol, String domicilio) {
        this.iden = iden;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.domicilio = domicilio;
    }
    public Usuario() {}
}