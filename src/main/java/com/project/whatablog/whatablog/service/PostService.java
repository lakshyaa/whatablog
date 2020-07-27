package com.project.whatablog.whatablog.service;

import com.project.whatablog.whatablog.models.Post;
import com.project.whatablog.whatablog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    Logger log=Logger.getLogger("PostService.class");

    public Post updatePostWithLikes(Long id)
    {

        Post post= postRepository.findById(id);

        log.info("post came -------------->"+post+"po");

        if(post.getLikes()==null)
            post.setLikes(1);

        else {
            Integer likes = post.getLikes();
            likes += 1;
            post.setLikes(likes);
        }

          return postRepository.save(post);
    }


}
