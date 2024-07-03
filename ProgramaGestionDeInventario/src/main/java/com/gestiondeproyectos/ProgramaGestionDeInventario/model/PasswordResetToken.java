package com.gestiondeproyectos.ProgramaGestionDeInventario.model;

import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.*;
@Entity
public class PasswordResetToken {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String token;
 
    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Usuario user;
 
    @Column(nullable = false)
    private Date expiryDate;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getToken() {
        return token;
    }
 
    public void setToken(String token) {
        this.token = token;
    }
 
    public Usuario getUser() {
        return user;
    }
 
    public void setUser(Usuario user) {
        this.user = user;
    }
 
    public Date getExpiryDate() {
        return expiryDate;
    }
 
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
 
    public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }
 
    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
}