package com.web.mylogin.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.mylogin.domain.member.Member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
   public String loginMember(
         @ModelAttribute LoginForm loginForm, 
         Model model, RedirectAttributes redirect, 
         HttpServletResponse resp){
      String loginId = loginForm.getLoginId();
      String password = loginForm.getPassword();
      
      Member loginMember = loginService.login(loginId, password);
      if(loginMember == null) {
         model.addAttribute("message", "로그인 실패");
         return "login";
      }

      Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
      resp.addCookie(idCookie);
      redirect.addAttribute("message", "로그인 성공");
      return "redirect:/";
   }
}
