package ex.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.web.util.UriComponentsBuilder;

public class URLReader {

   private String searchKeyword = "https://apis.data.go.kr/B551011/KorService1/searchKeyword1";
   private String detailCommon = "https://apis.data.go.kr/B551011/KorService1/detailCommon1";
   private String key = "encodingKey";
   
   public String keyword(String keyword, int numOfRows, int pageNo) {
      keyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
      String uriBuilder = UriComponentsBuilder
         .fromUriString(this.searchKeyword)
         .queryParam("serviceKey", this.key)
         .queryParam("keyword", keyword)
         .queryParam("MobileOS", "ETC")
         .queryParam("MobileApp", "AppTest")
         .queryParam("_type", "json")
         .queryParam("numOfRows", numOfRows)
         .queryParam("pageNo", pageNo)
         .build().toUriString()
      ;
      System.out.println(uriBuilder);

      try {
         URL url = new URL(uriBuilder);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
         StringBuilder sb = new StringBuilder();

         while(br.ready()) sb.append(br.readLine());

         return sb.toString();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return "";
   }

   public String detail(Integer contentId) {
      String uriBuilder = UriComponentsBuilder
         .fromUriString(this.detailCommon)
         .queryParam("serviceKey", this.key)
         .queryParam("contentId", contentId)
         .queryParam("MobileOS", "ETC")
         .queryParam("MobileApp", "AppTest")
         .queryParam("defaultYN", "Y")
         .queryParam("firstImageYN", "Y")
         .queryParam("areacodeYN", "Y")
         .queryParam("catcodeYN", "Y")
         .queryParam("addrinfoYN", "Y")
         .queryParam("mapinfoYN", "Y")
         .queryParam("overviewYN", "Y")
         .build().toUriString()
      ;
      System.out.println(uriBuilder);

      try {
         URL url = new URL(uriBuilder);
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
         StringBuilder sb = new StringBuilder();

         while(br.ready()) sb.append(br.readLine());

         return sb.toString();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return "";
   }
}
