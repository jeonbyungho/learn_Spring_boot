package ex.test;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class Keyword {
   @JsonProperty("title")
   private String title;
   
   @JsonProperty("addr1")
   private String addr1;
   @JsonProperty("addr2")
   private String addr2;
   @JsonProperty("areacode")
   private String areacode;
   @JsonProperty("booktour")
   private String booktour;
   
   private String cat1;
   
   private String cat2;

   private String cat3;
   
   @JsonProperty("contentid")
   private Long contentid;

   private String contenttypeid;

   private String createdtime;

   private String firstimage;

   private String firstimage2;

   private String cpyrhtDivCd;

   private String mapx;

   private String mapy;

   private String mlevel;

   private String modifiedtime;

   private String sigungucode;

   private String tel;
}
