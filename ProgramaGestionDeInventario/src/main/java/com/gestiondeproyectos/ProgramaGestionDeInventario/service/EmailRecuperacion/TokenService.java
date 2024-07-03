package com.gestiondeproyectos.ProgramaGestionDeInventario.service.EmailRecuperacion;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.PasswordResetToken;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;

public interface TokenService {

    public String createToken(Usuario user);

    public PasswordResetToken findByToken(String token);

    public void invalidateToken(PasswordResetToken token);
}

