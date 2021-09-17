package com.than.service;

import com.than.model.Blog;
import com.than.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        iBlogRepository.delete(id);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id);
    }


}
