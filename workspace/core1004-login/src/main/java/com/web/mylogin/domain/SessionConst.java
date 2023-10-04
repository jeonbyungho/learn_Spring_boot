package com.web.mylogin.domain;

// 상주만 정의
public enum SessionConst {
   LOGIN_MEMBER("loginMember");

   private final String str;

   public String getStr() {
      return str;
   }
   
   SessionConst(String str){
      this.str = str;
   }
   
}
