package com.web.mylogin.domain.login;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.mylogin.domain.member.Member;
import com.web.mylogin.domain.member.MemberRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
public class LoginControllerCookie {

   private final LoginService loginService;
   private final MemberRepository memberRepository;
   
   @PostConstruct
   public void init(){
      System.out.println("Cookie 로그인");
   }

   /*
    * name = memberId -> 쿠키의 Key값으로 Get 매핑을 한다.
    * required = false -> memberId가 필수 값이 아니므로, 로그인 안한 상태로 접속이 가능하다.
    */
   @GetMapping("/")
   public String homeLogin(
         @CookieValue(name = "memberId", required = false)Long memberId,
         Model model){
      // 로그인 상태가 아니라면 home으로 return.
      if(memberId == null) {
         System.err.println("Null Check memberId : " + memberId);
         return "home";
      }
      // DB 조회 한 후, 사용자가 없으면 null 처리하고 home을 return.
      Member loginMember = memberRepository.findById(memberId);
      if(loginMember == null) {
         System.err.println("Null Check loginMember : " + loginMember);
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
         HttpServletResponse resp,
         @RequestParam(defaultValue = "/") String redirecturi){
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
      return "redirect:" + redirecturi;
   }

   @PostMapping("/logout")
   public String logoutMember(HttpServletRequest req, HttpServletResponse resp){
      Cookie[] cs = req.getCookies();
      for(Cookie c :cs){
         if(c.getName().equals("memberId")){
            System.out.println("Cookie memberId : " + c.getValue());
            expireCookie(resp, "memberId");
            break;
         }
      }
      return "redirect:/";
   }

   private void expireCookie(HttpServletResponse resp, String cookieName){
      Cookie cookie = new Cookie(cookieName, null);
      cookie.setMaxAge(0);
      resp.addCookie(cookie);
   }

   
}
