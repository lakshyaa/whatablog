package com.project.whatablog.whatablog.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserBlogger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @OneToMany(mappedBy = "userBlogger",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> posts=new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    private String password;
}


