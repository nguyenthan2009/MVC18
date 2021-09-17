package com.than.repository;

import com.than.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Long id);
    Blog findById(Long id);

}
