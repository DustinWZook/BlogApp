package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @RequestMapping (path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "posts index page";
    }

    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postPage(@PathVariable int id){
        return "view post page with id of " + id;
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost(){
        return "view create post form";
    }

    @PostMapping (path = "/posts/create")
    @ResponseBody
    public String adPage(){
        return "info from post request";
    }


}
