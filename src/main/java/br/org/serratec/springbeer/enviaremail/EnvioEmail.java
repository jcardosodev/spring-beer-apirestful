package br.org.serratec.springbeer.enviaremail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String usuario;

    public void sendSimpleMessage(String to, String subject, String text) {
        System.out.println("Email sent successfully to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + text);
    }
}
