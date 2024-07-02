package com.edigest.myFirstProject.service;

import com.edigest.myFirstProject.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;




    @Test
    void testSendMail(){
        emailService.sendEmail(
                "engr.jameelahmed2@gmail.com",
                "Testing java Mail sender",
                "Kesa hy Jameel Bhai"
        );
    }
}
