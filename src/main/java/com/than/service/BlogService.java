package com.than.service;

import com.than.model.Blog;
import com.than.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
         iBlogRepository.save(blog);
    }

    @Override
    public Iterable<Blog> findAllByBlogContaining(String blog) {
        return iBlogRepository.findAllByBlogContaining(blog);
    }

    @Override
    public void deleteById(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepository.findById(id);
    }


}
