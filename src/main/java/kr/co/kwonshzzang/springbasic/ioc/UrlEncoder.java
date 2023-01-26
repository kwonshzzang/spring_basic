package kr.co.kwonshzzang.springbasic.ioc;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Component
public class UrlEncoder implements IEncoder {
    public String encode(String message)  {
        String result = null;
        try {
            result = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
