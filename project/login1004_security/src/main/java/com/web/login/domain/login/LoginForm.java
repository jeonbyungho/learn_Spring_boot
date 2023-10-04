package com.web.login.domain.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class LoginForm {
   private String loginId;
   private String password;
}
