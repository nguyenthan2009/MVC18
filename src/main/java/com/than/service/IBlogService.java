package com.than.service;

import com.than.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();
    Optional<Blog> findById(Long id);
    void deleteById(Long id);
    void save(Blog blog);
    Iterable<Blog> findAllByBlogContaining(String title);

}
