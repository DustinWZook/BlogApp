package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.AttributedString;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }




    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String postPage(@PathVariable long id, Model model){
        Post currentPost = postDao.getReferenceById(id);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }

//    @GetMapping ("/posts/create")
//    public String createAdPage(){
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name = "username") String username,@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        Post post = new Post();
//        User user = userDao.findByUsername(username);
//        post.setTitle(title);
//        post.setBody(body);
//        post.setUser(user);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String createAdPage(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit/")
    public String getEditPost(@PathVariable Long id, Model model){
//        long postId = Long.parseLong(id);
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);
        return "redirect:/posts/edit";
    }

//    @PostMapping("/posts/edit/{id}")
//    public String editPost(@ModelAttribute Post post, @PathVariable("id") long id){
//        Post updatePost = postDao.getReferenceById(id);
//        postDao.save(post);
//        return "redirect:/posts";
//    }


}
