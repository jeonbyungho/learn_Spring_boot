package com.web.mylogin.domain.filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {

      HttpServletRequest httpRequest = (HttpServletRequest) request;
      String uri = httpRequest.getRequestURI();
      // UUID : 네트워크상에서 고유성을 보장하는 ID를 만들기 위한 표준 규약이다. 다만 여기서는 요쳥을 구분하기 위해서 이용함.
      String uuid = UUID.randomUUID().toString();
      
      try {
         chain.doFilter(httpRequest, response);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         System.out.println("UUID : " + uuid);
         System.out.println("URI : " + uri);
      }
   }
   
}
