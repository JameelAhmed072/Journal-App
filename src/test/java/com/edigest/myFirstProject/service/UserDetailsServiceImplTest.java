//package com.edigest.myFirstProject.service;
//
//import com.edigest.myFirstProject.entity.User;
//import com.edigest.myFirstProject.repository.UserRepository;
//import com.edigest.myFirstProject.services.UserDetailsServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class UserDetailsServiceImplTest {
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("saad").password("saad123").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("saad");
//        Assertions.assertNotNull(user);
//    }
//}
