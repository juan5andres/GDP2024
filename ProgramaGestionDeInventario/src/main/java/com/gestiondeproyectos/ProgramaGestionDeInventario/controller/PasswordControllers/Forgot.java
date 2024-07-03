package com.gestiondeproyectos.ProgramaGestionDeInventario.controller.PasswordControllers;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.password.PasswordForgotDto;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.password.PasswordResetTokenRepository;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Mail;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.PasswordResetToken;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.EmailRecuperacion.EmailServiceImpl;


import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/forgot-password")
public class Forgot {
 
    @Autowired 
    private UsuarioService userService;

    @Autowired 
    private PasswordResetTokenRepository tokenRepository;

    @Autowired 
    private EmailServiceImpl emailService;
 
    @ModelAttribute("forgotPasswordForm")
    public PasswordForgotDto forgotPasswordDto() {
        return new PasswordForgotDto();
    }
 
    @GetMapping
    public String displayForgotPasswordPage() {
        return "forgot-password";
    }
 
    @PostMapping
    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Validated PasswordForgotDto form,
                                            BindingResult result,
                                            HttpServletRequest request) {
 
        if (result.hasErrors()){
            return "forgot-password";
        }
 
        Usuario user = userService.findByEmail(form.getEmail());
        if (user == null){
            result.rejectValue("email", null, "No hemos podido encontrar tu mail. Revisa que no tenga errores.");
            return "forgot-password";
        }
 
        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(30);
        tokenRepository.save(token);
 
        Mail mail = new Mail();
        mail.setFrom("SGI2024UNNOBA@gmail.com");
        mail.setTo(user.getEmail());
        mail.setSubject("Pedido de recuperación de contraseña");
 
        Map<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("user", user);
        model.put("signature", "https://SGI2024UNNOBA.com");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        model.put("resetUrl", url + "/reset-password?token=" + token.getToken());
        mail.setModel(model);
        emailService.sendEmail(mail);
 
        return "redirect:/forgot-password?success";
 
    }
 
}