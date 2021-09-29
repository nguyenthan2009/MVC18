//package com.than.controller;
//import com.than.dto.ResponseMessage;
//import com.than.model.Blog;
//import com.than.service.IBlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("blog")
//public class RestBlogController {
//    @Autowired
//    IBlogService blogService;
//    @PostMapping
//    public ResponseEntity<?> createBlog(@RequestBody Blog blog){
//        blogService.save(blog);
//        return new ResponseEntity<>(new ResponseMessage("create success!"), HttpStatus.OK);
//    }
//    @GetMapping
//    public ResponseEntity<?> getListBlog(){
//        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
//    }
//    @GetMapping("/search")
//    public ResponseEntity<?> findAllByTitle( String title){
//        return new ResponseEntity<>(blogService.findAllByBlogContaining(title),HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<?> detailBlog(@PathVariable Long id){
//        Optional<Blog> blog = blogService.findById(id);
//        if(!blog.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteBlog(@PathVariable Long id){
//        Optional<Blog> blog = blogService.findById(id);
//        if(!blog.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        blogService.deleteById(id);
//        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
//        Optional<Blog> blog1 = blogService.findById(id);
//        if(!blog1.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        blogService.save(blog);
//        return new ResponseEntity<>(new ResponseMessage("Update Success!"), HttpStatus.OK);
//    }
//
//
//
//}
