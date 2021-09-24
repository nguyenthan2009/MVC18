package com.than.repository;

import com.than.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Iterable<Blog> findAllByBlogContaining(String blog);

}
