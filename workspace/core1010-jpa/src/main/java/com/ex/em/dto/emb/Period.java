package com.ex.em.dto.emb;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Period {
   private LocalDateTime starDate;
   private LocalDateTime endDate;

   public Period(){

   }
   
   public Period(LocalDateTime starDate, LocalDateTime endDate){
      this.starDate = starDate;
      this.endDate = endDate;
   }
}
