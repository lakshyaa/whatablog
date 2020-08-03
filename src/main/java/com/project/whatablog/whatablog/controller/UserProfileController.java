package com.project.whatablog.whatablog.controller;

import com.project.whatablog.whatablog.models.UserBlogger;
import com.project.whatablog.whatablog.repository.UserBloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
ProfileController


 */

@RestController
@RequestMapping("/profile")
public class UserProfileController {


    @Autowired
    private UserBloggerRepository userBloggerRepository;

    @GetMapping
    @RequestMapping("/allProfiles")
    public List<UserBlogger> getAllProfiles() {


        return userBloggerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/profile/{userName}")
    public UserBlogger getProfile(@PathVariable("id") String userName){

        return  userBloggerRepository.findFirstByUserName(userName);

    }




}
