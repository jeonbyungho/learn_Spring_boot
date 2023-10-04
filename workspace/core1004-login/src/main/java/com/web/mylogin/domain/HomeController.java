package com.web.mylogin.domain;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

   @Deprecated
   //@GetMapping("/")
   public String home(){
      return "home";
   }

}
