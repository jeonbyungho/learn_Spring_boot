package com.ex;

public class App {
    public static void main(String[] args) {
        Problem p = new Problem();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        // 2-1. Member와 Orders 테이블을 엔티티 객체로 생성 하시오
        // 2-2. MEMBER테이블에 임의의 데이터 1건과 ORDERS 테이블에 임의의데이터를 insert 후, console창에 MEMBER테이블의 내용출력하시오
        long id = p.p1(10);
        p.p1_out(id);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        // 2-3.  Member 엔티티에서 city, street, zipcode 컬럼을 임베디드 타입으로 객체를 분리 후 콘솔창에 출력하세요
        p.p2();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}