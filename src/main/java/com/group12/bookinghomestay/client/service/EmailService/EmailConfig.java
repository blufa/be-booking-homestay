package com.group12.bookinghomestay.client.service.EmailService;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender getJavaMailSender()
    {
        JavaMailSender mailSender = new JavaMailSenderImpl();
        ((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
        ((JavaMailSenderImpl) mailSender).setPort(25);

        ((JavaMailSenderImpl) mailSender).setUsername("devwebchichoo@gmail.com");
        ((JavaMailSenderImpl) mailSender).setPassword("nbhdwkvvyptdreek");

        Properties props = ((JavaMailSenderImpl) mailSender).getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
