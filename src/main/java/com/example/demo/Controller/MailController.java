package com.example.demo.Controller;

import com.example.demo.mailing.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="email")
public class MailController {
    @Autowired
    EmailService emailService;
}
