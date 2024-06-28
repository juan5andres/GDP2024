package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iden;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "rol_Iden", nullable = false)
    private Rol rol;

    @Column(name = "domicilio", nullable = false)
    private String domicilio;

    @Column(name = "password", nullable = false)
    private String password;

    // Constructor con todos los campos
    public Usuario(String nombre, String email, String telefono, Rol rol, String domicilio, String password) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.domicilio = domicilio;
        this.password = password;
    }

    // Constructor requerido por UserDetailsServiceImpl
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    // Constructor por defecto
    public Usuario() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(rol.getDescripcion()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
