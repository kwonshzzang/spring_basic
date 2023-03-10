package kr.co.kwonshzzang.springbasic.di;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base64 Encoding
        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println(result);

        // url encoding
        encoder = new Encoder(new UrlEncoder());
        result = encoder.encode(url);
        System.out.println(result);
    }
}
