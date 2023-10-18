package ex.test;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {
        URLReader u = new URLReader();
        //System.out.println(u.keyword("경기", 12, 3));
        //String json = u.detail(133645);
        String json = u.keyword("서울", 40, 1);
        ObjectMapper mapper = new ObjectMapper();
        String itemJson = mapper.readTree(json).findPath("item").toString();
        
        List<Keyword> keywords = mapper.readValue(itemJson, new TypeReference<List<Keyword>>(){});

        for(Keyword key :keywords){
            System.out.println("\n"+ key.getTitle() + " id " + key.getContentid());
            System.out.println(key.getAddr1());
        }
    }
}