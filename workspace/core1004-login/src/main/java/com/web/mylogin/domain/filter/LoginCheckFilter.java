package com.web.mylogin.domain.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import com.web.mylogin.domain.SessionConst;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

   private static final String[] whiteList
      = {"/", "/login", "/louout", "/members/add", "/css/*"};

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {

      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      String uri = httpRequest.getRequestURI();
      
      try {
         System.out.println("인증 체크 필터 시작 : " + uri);
         if(isLoginCheckPath(uri)){
            HttpSession session = httpRequest.getSession(false);
            if(session == null
            || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
               System.out.println("미 인증 사용자 요청");
               httpResponse.sendRedirect("/login?redirecturi=" + uri);
               return;
            }
         }
         chain.doFilter(httpRequest, response);
      } catch (Exception e) {
         throw e;
      } finally {
         System.out.println("인증 체크 필터 종료 : " + uri);
      }
   }

   // whiteList에 속한 URI는 사용자 인증 검증에서 제외.
   private boolean isLoginCheckPath(String uri) {
      return !PatternMatchUtils.simpleMatch(whiteList, uri);
      // simpleMatch(String[] patterns, String str) : for (String pattern : patterns) if (simpleMatch(pattern, str)) return true
   }
   
}
