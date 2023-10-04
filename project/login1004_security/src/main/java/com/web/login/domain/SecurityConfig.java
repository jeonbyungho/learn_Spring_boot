package com.web.login.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * <h3>스프링 시큐리티 설정</h3>
 * <p>
 * 기본적으로 인증되지 않은 사용자는 서비스를 사용할 수 없게끔 되어 있다.
 *  그대로 적용하기에는 곤란하므로 시큐리티의 설정을 통해 바로 잡아야 한다.
 * </p>
 * <ul>
 *    <li>@Configuration 스프링의 환경설정 파일임을 의미하는 애너테이션.</li>
 *    <li>@EnableWebSecurity 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션. 
 *    해당 어노테이션을 사용하면 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터가 적용된다.
 *    </li>
 * </ul>
 * 
 * <h4>HttpSecurity</h4>
 * <ul>
 *    <li>.formLogin 메서드는 스프링 시큐리티의 로그인 설정을 담당하는 부분</li>
 *    <li>.loginPage 로그인 페이지의 URL</li>
 *    <li>.defaultSuccessUrl 로그인 성공시에 이동하는 디폴트 페이지는 루트 URL</li>
 * </ul>
 */

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
