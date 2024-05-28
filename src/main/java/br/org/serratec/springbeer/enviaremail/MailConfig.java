package br.org.serratec.springbeer.enviaremail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-mail-host");
        mailSender.setPort(587); // or your mail server port
        mailSender.setUsername("your-username");
        mailSender.setPassword("your-password");
        return mailSender;
    }
}

