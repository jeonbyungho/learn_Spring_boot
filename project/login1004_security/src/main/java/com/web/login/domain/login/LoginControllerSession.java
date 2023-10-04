package com.web.login.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginControllerSession {

   private final LoginService loginService;
   
   @GetMapping("/login")
   public String loginPage(@ModelAttribute LoginForm loginForm){
      return "login";
   }

}
