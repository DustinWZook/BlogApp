package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDoa;
    private final UserRepository userDoa;
    public PostController(PostRepository postDoa, UserRepository userDoa){
        this.postDoa = postDoa;
        this.userDoa = userDoa;
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

    @GetMapping ("/posts/create")
    public String createAdPage(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createAd(@RequestParam(name = "username") String username,@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post();
        User user = userDoa.findByUsername(username);
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);
        postDoa.save(post);
        return "redirect:/posts";
    }


}
