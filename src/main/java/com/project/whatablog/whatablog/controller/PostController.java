package com.project.whatablog.whatablog.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.whatablog.whatablog.models.Comments;
import com.project.whatablog.whatablog.models.Post;
import com.project.whatablog.whatablog.models.UserBlogger;
import com.project.whatablog.whatablog.repository.PostRepository;
import com.project.whatablog.whatablog.repository.UserBloggerRepository;
import com.project.whatablog.whatablog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    public PostRepository postRepository;

    @Autowired
    private UserBloggerRepository userBloggerRepository;

    @Autowired
    public PostService postService;

    Logger log = Logger.getLogger("PostController.class");

    @RequestMapping("/addPost/{id}")
    @PostMapping
    public ResponseEntity addAPostForBlogger(@RequestBody Post post,@PathVariable("id")String id) {
        log.info("------------------------------>saving post to the database");

        UserBlogger userBlogger=userBloggerRepository.findById(Integer.parseInt(id)).get();
        post.setUserBlogger(userBlogger);
        post=postRepository.save(post);
        if(userBlogger.getPosts()==null)
        {
            ArrayList<Post> posts=new ArrayList<>();
            posts.add(post);
            userBlogger.setPosts(posts);

        }
        else
        {
            userBlogger.getPosts().add(post);
        }
        userBloggerRepository.save(userBlogger);
        return ResponseEntity.ok("-->Post saved");
    }

    @RequestMapping("/getPosts")
    @GetMapping
    @JsonIgnore
    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }

    @RequestMapping(path = "/updateLikes/{id}")
    @PostMapping
    public Post updateLikesForPost(@PathVariable("id") String id)
    {

        return postService.updatePostWithLikes(Long.parseLong(id));
    }

    @RequestMapping(path="/updateComments/{id}")
    @PostMapping
    public Post updateCommentsForPost(@PathVariable("id")String id, @RequestBody Comments comment)
    {
        log.info("adding comment is="+comment.getMessage());
        return  postService.updatePostWithComment(Long.parseLong(id),comment);
    }



}
