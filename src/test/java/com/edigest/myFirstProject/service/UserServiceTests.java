//package com.edigest.myFirstProject.service;
//
//import com.edigest.myFirstProject.entity.User;
//import com.edigest.myFirstProject.repository.UserRepository;
//import com.edigest.myFirstProject.services.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "saad",
//            "Jameel Ahmed",
//            "Waqar Ahmed",
//            "Aziz"
//    })
//    public void testFindByUserName(String a){
////        assertNotNull(userRepository.findByUserName(a));
//        User user = userRepository.findByUserName(a);
//        assertNotNull(user.getJournalEntries().isEmpty());
//    }
//
//    // ========>   now let's make custom source
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentProvider.class)
//    public void testSaveNewUser(User user){
//        assertTrue(userService.saveNewUser(user));
//    }
//
//
//
////    @Disabled
//    @Test
//    public void check(){
//        assertEquals(4, 2+2);
//    }
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "5,5,10",
//            "1,2,2"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a+b);
//    }
//
//}
