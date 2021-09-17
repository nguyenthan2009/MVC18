package com.than.service;

import com.than.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Long id);
    Blog findById(Long id);
}
