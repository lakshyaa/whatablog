package com.project.whatablog.whatablog.controller;

import com.project.whatablog.whatablog.models.Post;
import com.project.whatablog.whatablog.repository.PostRepository;
import com.project.whatablog.whatablog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    public PostRepository postRepository;

    @Autowired
    public PostService postService;

    Logger log = Logger.getLogger("PostController.class");

    @RequestMapping("/addPost")
    @PostMapping
    public ResponseEntity addAPostForBlogger(@RequestBody Post post) {

        postRepository.save(post);
        log.info("------------------------------>saving post to the database");

        return ResponseEntity.ok("-->Post saved");
    }

    @RequestMapping("/getPosts")
    @GetMapping
    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }

    @RequestMapping(path = "/updateLikes/{id}")
    @PostMapping
    public Post updateLikesForPost(@PathVariable("id") String id)
    {

        return postService.updatePostWithLikes(Long.parseLong(id));
    }



}
