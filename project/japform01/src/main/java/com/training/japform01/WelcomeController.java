package com.training.japform01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
   @GetMapping("/")
   public String welcomePage(Model model){
      model.addAttribute("data", "Spring boot");
      return "welcome";
   }
}
