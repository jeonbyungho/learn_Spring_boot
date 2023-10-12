package com.ex.mvcweb;

import org.springframework.stereotype.Component;

import com.ex.mvcweb.entity.Address;

import jakarta.annotation.PostConstruct;

@Component
public class TestInit {
   @PostConstruct
   public void init(){
      System.out.println("━━━━┫PostConstruct : " + getClass().getSimpleName());
   }
}
