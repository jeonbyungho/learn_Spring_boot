package com.ex.mvcweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
   @GetMapping("/")
   public String welcome(Model model){
      model.addAttribute("data", "Spring");
      return "welcome";
   }
}
