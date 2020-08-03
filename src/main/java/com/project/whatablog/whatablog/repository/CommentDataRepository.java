package com.project.whatablog.whatablog.repository;

import com.project.whatablog.whatablog.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDataRepository extends JpaRepository<Comments,Long> {


}
