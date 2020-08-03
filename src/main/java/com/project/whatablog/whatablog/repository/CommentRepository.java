package com.project.whatablog.whatablog.repository;

import com.project.whatablog.whatablog.models.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    @Autowired
    private CommentDataRepository commentDataRepository;

    public Comments save(Comments comment)
    {

        return  commentDataRepository.save(comment);
    }


}
