package sn.msae.sendmailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.msae.sendmailservice.entity.Information;
import sn.msae.sendmailservice.service.SendService;

import java.util.List;

@Controller
@RequestMapping("/api/sendmail")
public class SendController {

    @Autowired
    private SendService sendService;

    @CrossOrigin(origins = "https://portail.msae.sn", allowCredentials = "true")
    @PostMapping("/test")
    public ResponseEntity<Information> sendMail(@RequestBody Information information) {
        try {

            this.sendService.sendEmailForNewExpression(information);
            return new ResponseEntity(information, HttpStatus.OK);

        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}

