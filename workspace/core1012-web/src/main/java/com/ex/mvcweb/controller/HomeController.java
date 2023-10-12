package com.ex.mvcweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
   public HomeController(){
      System.out.println("생성됨");
   }

   @GetMapping("/")
   public String welcome(Model model){
      model.addAttribute("data", "Spring");
      log.info("Get : " + getClass().getSimpleName());
      return "welcome";
   }
}
