package com.gestiondeproyectos.ProgramaGestionDeInventario.controller.PasswordControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.password.PasswordResetDto;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.password.PasswordResetTokenRepository;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.PasswordResetToken;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.UsuarioService;
 
 
@Controller
@RequestMapping("/reset-password")
public class Reset {
 
    @Autowired 
    private UsuarioService userService;
    
    @Autowired 
    private PasswordResetTokenRepository tokenRepository;

    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;
 
    @ModelAttribute("passwordResetForm")
    public PasswordResetDto passwordReset() {
        return new PasswordResetDto();
    }
 
    @GetMapping
    public String displayResetPasswordPage(@RequestParam(required = false) String token,
                                           Model model) {
 
        PasswordResetToken resetToken = tokenRepository.findByToken(token);
        if (resetToken == null){
            model.addAttribute("error", "No hemos encontrado la solicitud de cambio de contraseña.");
        } else if (resetToken.isExpired()){
            model.addAttribute("error", "La solicitud de cambio de contraseña ha expirado, por favor, solicite una nueva.");
        } else {
            model.addAttribute("token", resetToken.getToken());
        }
 
        return "reset-password";
    }
 
    @PostMapping
    @Transactional
    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Validated PasswordResetDto form,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".passwordResetForm", result);
            redirectAttributes.addFlashAttribute("passwordResetForm", form);
            return "redirect:/reset-password?token=" + form.getToken();
        }
 
        PasswordResetToken token = tokenRepository.findByToken(form.getToken());
        Usuario user = token.getUser();
        String updatedPassword = passwordEncoder.encode(form.getPassword());
        userService.updatePassword(updatedPassword, user.getIden());
        tokenRepository.delete(token);
 
        return "redirect:/login?resetSuccess";
    }
 
}