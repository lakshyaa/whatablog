package com.project.whatablog.whatablog.service;

import com.project.whatablog.whatablog.models.Comments;
import com.project.whatablog.whatablog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comments save(Comments comment)
    {

        return  commentRepository.save(comment);
    }



}
