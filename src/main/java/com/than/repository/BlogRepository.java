package com.than.repository;

import com.than.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        String queryStr = "select  b from Blog as b";
        List<Blog> blogLists = entityManager.createQuery(queryStr, Blog.class ).getResultList();
        return blogLists;
    }

    @Override
    public void save(Blog blog) {
        if(blog!=null){
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void delete(Long id) {
        Blog blog = findById(id);
        if(blog!=null){
            entityManager.remove(blog);
        }
    }

    @Override
    public Blog findById(Long id) {
        String queryStr = "select b from Blog as b where b.id =:id";
        Blog blog = entityManager.createQuery(queryStr,Blog.class).setParameter("id",id).getSingleResult();
        return blog;
    }

}
