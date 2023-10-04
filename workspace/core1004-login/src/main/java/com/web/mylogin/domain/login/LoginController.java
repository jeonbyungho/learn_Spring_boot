package com.web.mylogin.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

   private final LoginService loginService;
   
   @GetMapping("/login")
   public String loginPage(@ModelAttribute LoginForm loginForm){
      return "login";
   }

   @PostMapping("/login")
   public String loginMember(@ModelAttribute LoginForm loginForm){
      String loginId = loginForm.getLoginId();
      String password = loginForm.getPassword();
      loginService.login(loginId, password);
      return "redirect:/";
   }
}
