package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }
    @PostMapping("/roll-dice")
    public String numberGuess(@RequestParam(name = "userGuess") Model model, String userGuess){
        model.addAttribute("userGuess", userGuess);
    return "results";
    }
}
