package com.project.whatablog.whatablog.repository;


import com.project.whatablog.whatablog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    PostDataRepository postDataRepository;

    public Post save(Post post)
    {
        return  postDataRepository.save(post);
    }


    public List<Post> findAll()
    {

        return  postDataRepository.findAll();
    }

    public Post findById(Long id)
    {
        System.out.println(postDataRepository.findById(id).get());
        return postDataRepository.findById(id).get();
    }







}
