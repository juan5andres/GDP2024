package com.gestiondeproyectos.ProgramaGestionDeInventario.service.EmailRecuperacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Mail;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
 
@Service
public class EmailServiceImpl {
 
    @Autowired
    private JavaMailSender emailSender;
 
    @Autowired
    private SpringTemplateEngine templateEngine;
 
    public void sendEmail(Mail mail) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
 
            Context context = new Context();
            context.setVariables(mail.getModel());
            String html = templateEngine.process("email-template", context);
 
            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());
 
            emailSender.send(message);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
 
}

