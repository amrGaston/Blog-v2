package com.blog.blog.repository;

import com.blog.blog.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
}
