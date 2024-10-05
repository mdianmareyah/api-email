package sn.msae.sendmailservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sn.msae.sendmailservice.entity.Information;


import java.io.UnsupportedEncodingException;


@Service
public class SendService {

    @Autowired
    private JavaMailSender javaMailSender;



    @Value("$(Portail)")
    private String fromMail;

    public void sendEmailForNewExpression(Information information) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom(fromMail);
        mimeMessageHelper.setTo("contact@mutuelle-msaes.sn");

        mimeMessageHelper.setSubject(information.getObjet());
        String content = "<h3>Nom: " + information.getNom() + "</h3><br>" +
                "<h2>Matricule: " + information.getMatricule() + "</h2><br>" +
                "<b>veillez recevoir la demande d'information: </b><br>" + "\n" +
                "<b>" + information.getMessage() + "</b><br>";
        mimeMessageHelper.setText(content,true);

        javaMailSender.send(mimeMessage);
    }


}
