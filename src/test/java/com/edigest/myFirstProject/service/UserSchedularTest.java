package com.edigest.myFirstProject.service;

import com.edigest.myFirstProject.schedular.UserSchedular;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedularTest {

    @Autowired
    private UserSchedular userSchedular;

    @Test
    public void testFetchUsersAndSendMail(){
        userSchedular.fetchUsersAndSendSaMail();
    }

}
