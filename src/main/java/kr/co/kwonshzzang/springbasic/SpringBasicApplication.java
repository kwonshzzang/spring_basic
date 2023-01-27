package kr.co.kwonshzzang.springbasic;

import kr.co.kwonshzzang.springbasic.ioc.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringBasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBasicApplication.class, args);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        ApplicationContext context = ApplicationContextProvider.getContext();
//      Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//      UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//      Encoder encoder = context.getBean(Encoder.class);
//      Encoder encoder = new Encoder(base64Encoder);

        Encoder encoder = context.getBean("encoderUrl", Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);
//
//      encoder.setIEncoder(urlEncoder);
//      result = encoder.encode(url);
//      System.out.println(result);
    }
}

@Configuration
class AppConfig {
    @Bean
    public Encoder encoderBase64(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean
    public Encoder encoderUrl(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }

}
