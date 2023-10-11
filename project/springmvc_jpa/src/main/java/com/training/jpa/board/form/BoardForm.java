package com.training.jpa.board.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class BoardForm {
   private String title;
   private String author;
   private String content;
}
