package com.training.login.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
   
   @Bean
   SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.authorizeHttpRequests(
         (authorizeHttpRequests)-> authorizeHttpRequests
         .requestMatchers(new AntPathRequestMatcher("/**"))
         .permitAll())
         .formLogin((formLogin)-> formLogin
         .loginPage("/login")
         .defaultSuccessUrl("/"))
         ;
         return httpSecurity.build();
   }

   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
}
