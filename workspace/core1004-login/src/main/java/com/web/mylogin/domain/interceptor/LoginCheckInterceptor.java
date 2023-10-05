package com.web.mylogin.domain.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.web.mylogin.domain.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String uri = request.getRequestURI();
      System.out.println("┌─[Security] 실행 사용자 인증 : " + uri);

      HttpSession session = request.getSession(false);
      if(session == null
      || session.getAttribute(SessionConst.LOGIN_MEMBER) == null){
         System.out.println("└─[Security] 미인증 사용자");
         response.sendRedirect("/login?redirecturi=" + uri);
         return false;
      }
      System.out.println("└─[Security] 완료 사용자 인증");
      return true;
   }
   
}
