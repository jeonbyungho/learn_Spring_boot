package ex.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @ToString @AllArgsConstructor @NoArgsConstructor
public class Keyword {
   @JsonProperty("title")
   private String title;
   @JsonProperty("addr1")
   private String addr1;
   @JsonProperty("addr2")
   private String addr2;
   @JsonProperty("contentid")
   private Long contentid;
}
