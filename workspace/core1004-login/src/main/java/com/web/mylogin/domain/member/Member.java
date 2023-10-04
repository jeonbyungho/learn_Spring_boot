package com.web.mylogin.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Member {
   private Long   id;         // 식별 번호
   private String loginId;    // 로그인 ID
   private String name;       // 사용자의 이름
   private String password;   // 비밀번호
}
