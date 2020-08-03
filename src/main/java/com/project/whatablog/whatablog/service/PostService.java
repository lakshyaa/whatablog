package com.project.whatablog.whatablog.service;

import com.project.whatablog.whatablog.models.Comments;
import com.project.whatablog.whatablog.models.Post;
import com.project.whatablog.whatablog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;


    Logger log = Logger.getLogger("PostService.class");

    public Post updatePostWithLikes(Long id) {

        Post post = postRepository.findById(id);

        log.info("post came -------------->" + post + "po");

        if (post.getLikes() == null)
            post.setLikes(1);

        else {
            Integer likes = post.getLikes();
            likes += 1;
            post.setLikes(likes);
        }

        return postRepository.save(post);
    }

    public Post updatePostWithComment(Long id, Comments comment) {
        Post post = postRepository.findById(id);
        log.info("adding comment ----------------->" + post);

        comment=commentService.save(comment);
        comment.setPost(post);
        if (post.getComments() == null) {
            ArrayList<Comments> comments = new ArrayList<>();
            comments.add(comment);
            post.setComments(comments);
        } else {

        post.getComments().add(comment);
        }

        return postRepository.save(post);
    }

}
