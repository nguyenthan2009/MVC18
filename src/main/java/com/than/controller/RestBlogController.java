package com.than.controller;
import com.than.dto.ResponseMessage;
import com.than.model.Blog;
import com.than.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("blog")
public class RestBlogController {
    @Autowired
    IBlogService blogService;
    @PostMapping
    public ResponseEntity<?> createSmartPhone(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(new ResponseMessage("create success!"), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getListSmartPhone(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> findAllByProducer( String producer){
        return new ResponseEntity<>(blogService.findAllByBlogContaining(producer),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detailSmartPhone(@PathVariable Long id){
        Optional<Blog> smartPhone = blogService.findById(id);
        if(!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSmartPhone(@PathVariable Long id){
        Optional<Blog> smartPhone = blogService.findById(id);
        if(!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSmartPhone(@PathVariable Long id, @RequestBody Blog blog){
        Optional<Blog> smartPhone1 = blogService.findById(id);
        if(!smartPhone1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blog);
        return new ResponseEntity<>(new ResponseMessage("Update Success!"), HttpStatus.OK);
    }



}
