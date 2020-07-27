package com.project.whatablog.whatablog.repository;

import com.project.whatablog.whatablog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDataRepository extends JpaRepository<Post,Long> {



}
