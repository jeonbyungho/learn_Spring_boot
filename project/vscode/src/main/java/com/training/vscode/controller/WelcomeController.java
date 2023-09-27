package com.training.vscode.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {
   
   @RequestMapping("/")
   public String welcomePage(Model model){
      model.addAttribute("title", "Vscode");
      model.addAttribute("now", LocalDateTime.now());
      return "welcome";
   }
}
