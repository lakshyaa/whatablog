package com.project.whatablog.whatablog.repository;

import com.project.whatablog.whatablog.models.UserBlogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserBloggerRepositoryImpl  {

    @Autowired
    private  UserBloggerRepository repository;

    public UserBlogger findByUserName(String name) {

        return repository.findFirstByUserName(name);

    }
    public  UserBlogger save(UserBlogger userBlogger)
    {
        return  repository.save(userBlogger);
    }
}
