package com.web.mylogin.domain.interceptor;

import java.util.UUID;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor{

   public static final String LOG_ID = "logId";

   // 인터셉터 호출 전
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      
      String uri = request.getRequestURI();
      String uuid = UUID.randomUUID().toString();
      
      request.setAttribute(LOG_ID, "simple data " + uuid);

      System.out.println("┌─[preHandle] UUID : " + uuid);
      System.out.println("├─[preHandle] URI : " + uri);
      System.out.println("├─[preHandle] Handler : " + handler.toString());
      System.out.println("└─[preHandle] "+ LOG_ID + ": " + request.getAttribute("LOG_ID"));
      return true;
   }

   // 인터셉터 호출 후
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      System.out.println("──[postHandle] : " + modelAndView);
   }

   // 요청 완료 이후
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      
      String uri = request.getRequestURI();
      String uuid = UUID.randomUUID().toString();
      
      System.out.println("┌─[afterCompletion] UUID : " + uuid);
      System.out.println("├─[afterCompletion] URI : " + uri);
      System.out.println("├─[afterCompletion] Handler : " + handler.toString());
      
      // Exception 발생 시
      if(ex != null){
         System.out.println("└─[afterCompletion] Exception" + ex.getMessage());
         return;
      }
      System.out.println("└─[afterCompletion] "+ LOG_ID + ": " + request.getAttribute("LOG_ID"));
   }
   
}
