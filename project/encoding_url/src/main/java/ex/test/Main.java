package ex.test;


public class Main {
    public static void main(String[] args) {
        URLReader u = new URLReader();
        System.out.println(u.keyword("경기", 12, 3));
        System.out.println(u.detail(133645));
    }
}