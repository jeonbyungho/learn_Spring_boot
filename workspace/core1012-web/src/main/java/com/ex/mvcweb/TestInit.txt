package com.ex.mvcweb;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TestInit {
   @PostConstruct
   public void init(){
      System.out.println("━━━━┫PostConstruct : " + getClass().getSimpleName());
   }

   public static void main(String[] args) {
      /* 파라미터 가변인자
       * 자바에서는 파라미터 개수가 다르면 다른 메서드를 인식한다.
       * 동일한 기능을 하지만, 파라미터가 가변적으로 변경되는 경우 오버로딩을 사용한다.
       * 그런데 오버로딩 파라미터 개수에 맞춰 메서드가 계속 늘어나는 구조이다.
       * 
       * - Map
       * void method(Map<String, type> param)
       * 
       * - Array
       * void method(String [] param)
       * 
       * - List
       * void method(List<type> param)
       * 
       * - VO, DTO
       * void method(ParamVO param)
       * 
       * - 가변인자 : 동적으로 파라미터를 받을 수있다.
       * void method(type... param)
       * 파라미터는 type의 배열 형태가 된다. -> type[]
      */
      method(12);
   }

   private static void method(String... param){
      System.out.println("first");
      for(String p : param){
         System.out.println(p);
      }
   }

   private static void method(int num, String... param){
      System.out.println("two");
      System.out.println(2);
      System.out.println("num : " + num);
      System.out.println("param length : " + param.length);
      for(String p : param){
         System.out.println(p);
      }
   }
}
