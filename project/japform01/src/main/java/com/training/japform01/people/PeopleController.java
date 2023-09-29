package com.training.japform01.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequestMapping("people")
@AllArgsConstructor
public class PeopleController {
   
   private final PeopleService peopleService;

   @GetMapping("/signup")
   public String signUpPage(@ModelAttribute PeopleForm peopleForm){
      return "people/signup";
   }

   @PostMapping("/signup")
   public String signUp(@Valid PeopleForm peopleForm, BindingResult bindingRs, Model model) {
      log.info(peopleForm.toString());
      if(bindingRs.hasErrors()) {
         return "people/signup";
      }
      People people = peopleService.signUp(peopleForm);
      model.addAttribute("people", people);
      return "people/mypage";
   }

   @GetMapping("/signin")
   public String signInPage(@ModelAttribute PeopleForm peopleForm){
      return "people/signin";
   }

   @PostMapping("/signin")
   public String signIn(@RequestParam String userName, @RequestParam String password, Model model){
      People people = peopleService.signIn(userName, password);
      if(people == null) return "people/signin";
      model.addAttribute("people", people);
      return "people/mypage";
   }
   
}
