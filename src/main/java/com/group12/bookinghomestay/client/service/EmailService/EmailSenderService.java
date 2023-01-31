package com.group12.bookinghomestay.client.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private Environment env;
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("devwebchichoo@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    public void sendActiveEmail(String to, String token) {
        String subject = "Active your account";
        String envPath = env.getProperty("frontend.environment.path");
        String body = "Hi there,\n We want to announce that you have registered successfully your account on gotrip ! " +
                "Please activate your account to complete your account setup by go to the link down below.Best regards, gotrip\n" +
                envPath + "active?token=" + token;
        sendSimpleEmail(to, body, subject);
    }
}
