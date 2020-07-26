package com.project.whatablog.whatablog.controller;

import com.project.whatablog.whatablog.models.UserBlogger;
import com.project.whatablog.whatablog.repository.UserBloggerRepository;
import com.project.whatablog.whatablog.repository.UserBloggerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.logging.Logger;

@RestController
public class UserLoginController {

    @Autowired
    private UserBloggerRepositoryImpl userBloggerRepository;
    private Logger log = Logger.getLogger("UserLoginController.class");


    @PostMapping("/newuser")
    public ResponseEntity createUser(@RequestBody UserBlogger user) {
        log.info("saving the new user----------------------------------->");
        if (checkUserNameIfPresent(user) == null) {
            userBloggerRepository.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("All good Successfully Registered!");
        }
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).body("userName already present!");
    }

    @PostMapping("/checkUser")
    public UserBlogger checkUserNameIfPresent(@RequestBody UserBlogger newUser) {

        System.out.println("new user name is=" + newUser.getUserName());
        return userBloggerRepository.findByUserName(newUser.getUserName());
    }


    @PostMapping("/checklogin")
    public ResponseEntity loginCheck(@RequestBody UserBlogger user) {
        log.info("user loggig into the system------------------------------------->");

        UserBlogger found = userBloggerRepository.findByUserName(user.getUserName());
        if (found != null) {

            if (found.getPassword() .equals(user.getPassword())) {
                return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfull Authentication !");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Credentials are not correct");
    }
}
