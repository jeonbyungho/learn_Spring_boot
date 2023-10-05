package com.training.exam.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
   
   @GetMapping("/")
   public String homePage(Model model){
      model.addAttribute("title", "Spring Boot!");
      model.addAttribute("data", "스프링 부트");
      return "home";
   }
}
