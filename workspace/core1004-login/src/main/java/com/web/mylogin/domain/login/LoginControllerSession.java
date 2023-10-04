package com.web.mylogin.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.mylogin.domain.SessionConst;
import com.web.mylogin.domain.member.Member;
import com.web.mylogin.domain.member.MemberRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginControllerSession {

   private final LoginService loginService;
   private final MemberRepository memberRepository;
   
   @PostConstruct
   public void init(){
      System.out.println("Session 로그인");
   }

   @GetMapping("/")
   public String homeLogin(HttpServletRequest req, Model model){
      HttpSession session = req.getSession(false);
      if(session == null) {
         System.err.println("Null Check session : " + session);
         return "home";
      }
      Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER.getStr());
      if(loginMember == null) {
         System.err.println("Null Check loginMember : " + loginMember);
         return "home";
      }

      Long memberId = loginMember.getId();
      if(memberId != memberRepository.findById(memberId).getId()){
         System.err.println("MemberId : Mismatch");
         return "home";
      }

      // 로그인 성공 loginHome을 return.
      model.addAttribute("member", loginMember);
      return "loginHome";
   }
   
   @GetMapping("/login")
   public String loginPage(@ModelAttribute LoginForm loginForm){
      return "login";
   }

   @PostMapping("/login")
   public String loginMember(
         @ModelAttribute LoginForm loginForm, 
         Model model, RedirectAttributes redirect, 
         HttpServletRequest req){
      String loginId = loginForm.getLoginId();
      String password = loginForm.getPassword();
      
      Member loginMember = loginService.login(loginId, password);
      if(loginMember == null) {
         model.addAttribute("message", "로그인 실패");
         return "login";
      }

      HttpSession session = req.getSession();
      session.setAttribute(SessionConst.LOGIN_MEMBER.getStr(), loginMember);
      
      redirect.addAttribute("message", "로그인 성공");
      return "redirect:/";
   }

   @PostMapping("/logout")
   public String logoutMember(HttpServletRequest req){
      HttpSession session = req.getSession(false);
      if(session != null) {
         session.invalidate();
      }
      return "redirect:/";
   }
}
