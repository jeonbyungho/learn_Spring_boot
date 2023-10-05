package com.web.mylogin.domain;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.mylogin.domain.filter.LogFilter;
import com.web.mylogin.domain.filter.LoginCheckFilter;

import jakarta.servlet.Filter;

@Configuration
public class WebConfig {
   
   @Bean
   public FilterRegistrationBean<Filter> logFilter(){
      FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
      filterRegistrationBean.setFilter(new LogFilter());          // Filter 등록
      filterRegistrationBean.setOrder(1);                   // Filter 순서 지정
      filterRegistrationBean.addUrlPatterns("/*"); // 적용 URL
      return filterRegistrationBean;
   }

   @Bean
   public FilterRegistrationBean<Filter> loginCheckFilter(){
      FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
      filterRegistrationBean.setFilter(new LoginCheckFilter());   // Filter 등록
      filterRegistrationBean.setOrder(2);                   // Filter 순서 지정
      filterRegistrationBean.addUrlPatterns("/*"); // 적용 URL
      return filterRegistrationBean;
   }
}
