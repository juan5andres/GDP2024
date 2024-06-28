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

    public Long getPersonaDeContacto() {
        return personaDeContacto;
    }

    public void setPersonaDeContacto(Long personaDeContacto) {
        this.personaDeContacto = personaDeContacto;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Boolean getBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }
}
