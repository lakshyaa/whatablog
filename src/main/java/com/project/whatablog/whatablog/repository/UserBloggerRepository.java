package com.project.whatablog.whatablog.repository;

import com.project.whatablog.whatablog.models.UserBlogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


public interface UserBloggerRepository  extends JpaRepository<UserBlogger,Integer> {

    public  UserBlogger findFirstByUserName(String name);


}
