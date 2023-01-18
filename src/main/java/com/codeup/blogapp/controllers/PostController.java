package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDoa;
    public PostController(PostRepository postDoa){
        this.postDoa = postDoa;
    }
    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = postDoa.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable long id, Model model){
        Post currentPost = postDoa.getReferenceById(id);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }
//
//    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String createPost(){
//        return "view create post form";
//    }
//
//    @PostMapping (path = "/posts/create")
//    @ResponseBody
//    public String adPage(){
//        return "info from post request";
//    }


}
