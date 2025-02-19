package com.edigest.myFirstProject.controller;

import com.edigest.myFirstProject.api.response.WeatherResponse;
import com.edigest.myFirstProject.entity.User;
import com.edigest.myFirstProject.repository.UserRepository;
import com.edigest.myFirstProject.services.UserService;
import com.edigest.myFirstProject.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public ResponseEntity<?> getAll(){
//        List<User> allUsers = userService.getAllUsers();
//        if(allUsers != null && !allUsers.isEmpty()){
//            return new ResponseEntity<>(allUsers,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDB = userService.findByUserName(userName);
        userInDB.setUserName(user.getUserName());
        userInDB.setPassword(user.getPassword());
        userService.saveNewUser(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Quetta");
        String greeting = "";
        if(weatherResponse != null){
            greeting = " ,Weather feels like "+weatherResponse.getCurrent().getFeelslike_c();
        }
        return new ResponseEntity<>("Hi "+ authentication.getName() + greeting ,HttpStatus.OK);
    }


}
