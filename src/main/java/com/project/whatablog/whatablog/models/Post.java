package com.project.whatablog.whatablog.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    private String message;

    public UserBlogger getUserBlogger() {
        return userBlogger;
    }

    public void setUserBlogger(UserBlogger userBlogger) {
        this.userBlogger = userBlogger;
    }

    @ManyToOne
    private UserBlogger userBlogger;

    private String likes;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comments> comments=new ArrayList<>();



}
