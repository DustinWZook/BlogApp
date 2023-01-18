package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping ("/posts/create")
    public String createAdPage(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createAd(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        postDoa.save(post);

        return "redirect:/posts";
    }


}
