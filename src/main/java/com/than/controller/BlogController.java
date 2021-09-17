package com.than.controller;

import com.than.model.Blog;
import com.than.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping("/blog")
    public ModelAndView listBlog(){
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listBlog",blogList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("createForm",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createBlog(@ModelAttribute("createForm") Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editForm",blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("editForm") Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detailBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detailBlog",blog);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",blog);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("deleteForm") Blog blog){
        blogService.delete(blog.getId());
        return "redirect:/blog";
    }

}
