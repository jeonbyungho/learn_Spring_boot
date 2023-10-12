package com.ex.jpql.application;


public class App {
   
   public static void main(String[] args) {
      Manager ex = new Ex05();
      ex.execute();
      System.out.println("★──> " + ex.getClass().getSimpleName());
   }
}
