package com.gestiondeproyectos.ProgramaGestionDeInventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "domicilio", nullable = false)
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

    public Long getIden() {
        return iden;
    }

    public void setIden(Long iden) {
        this.iden = iden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}