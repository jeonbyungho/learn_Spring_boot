package com.web.mylogin.domain;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.mylogin.domain.filter.LogFilter;
import com.web.mylogin.domain.filter.LoginCheckFilter;
import com.web.mylogin.domain.interceptor.LogInterceptor;
import com.web.mylogin.domain.interceptor.LoginCheckInterceptor;

import jakarta.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
   
   // Servlet Filter는 WebMvcConfigurer 인터페이스를 필요하지 않음.
   @Bean
   public FilterRegistrationBean<Filter> logFilter(){
      FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
      filterRegistrationBean.setFilter(new LogFilter());          // Filter 등록
      filterRegistrationBean.setOrder(1);                   // Filter 순서 지정
      filterRegistrationBean.addUrlPatterns("/*"); // 적용 URL
      return filterRegistrationBean;
   }

   //@Bean
   public FilterRegistrationBean<Filter> loginCheckFilter(){
      FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
      filterRegistrationBean.setFilter(new LoginCheckFilter());   // Filter 등록
      filterRegistrationBean.setOrder(2);                   // Filter 순서 지정
      filterRegistrationBean.addUrlPatterns("/*"); // 적용 URL
      return filterRegistrationBean;
   }

   // Spring Interceptor는 WebMvcConfigurer 인터페이스가 강요됨.
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new LogInterceptor())
         .order(1)
         .addPathPatterns("/**")
         .excludePathPatterns("/css/**")
      ;
      registry.addInterceptor(new LoginCheckInterceptor())
         .order(2)
         .addPathPatterns("/**")
         .excludePathPatterns("/", "/login", "/members/add", "/css/**")
      ;
   }
   
}
