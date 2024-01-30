package org.example.Service.impl;



import org.example.Service.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class EmailServiceImpl implements EmailService {
    @Override
    public void addEmailHistory(String email, Integer msg) {
        EMAIL_HISTORY_MAP.put(email,msg);
    }

    @Override
    public void sendEmail(String toEmail, Integer msg) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "azizovbehruz445@gmail.com";
        String password = "moer rlga lnyu sxrb";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Mail Subject");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg.toString(), "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

    private static EmailServiceImpl emailService;

    public static EmailServiceImpl getInstance() {
        if (emailService == null) {
            emailService = new EmailServiceImpl();
            return emailService;
        }
        return emailService;
    }
}