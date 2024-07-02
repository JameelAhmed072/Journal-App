package com.edigest.myFirstProject.services;

import com.edigest.myFirstProject.entity.User;
import com.edigest.myFirstProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
//    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEndcoder = new BCryptPasswordEncoder();
    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEndcoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList("USER"));
            userRepository.save(user);
            log.info("waa adeee Jameel, New user add ogaya");
            return true;
        }catch (Exception e){
            log.error("error by bhai");
            log.warn("warning by bhai");
            log.debug("debug by bhai");
            log.trace("trace by bhai");
            return false;
        }

    }
    public void saveAdmin(User user){
        user.setPassword(passwordEndcoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deleteUserById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }

}
