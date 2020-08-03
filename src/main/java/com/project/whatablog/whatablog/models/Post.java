package com.project.whatablog.whatablog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", message='" + message + '\'' +
                ", userBlogger=" + userBlogger +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

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


    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
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

    private Integer likes;



    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Comments> comments=new ArrayList<>();



}
