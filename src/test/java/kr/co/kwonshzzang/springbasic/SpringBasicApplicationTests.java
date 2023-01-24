package kr.co.kwonshzzang.springbasic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.kwonshzzang.springbasic.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBasicApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("------------------------");

        //Text JSON -> Object
        //Object -> Text JSON

        //controller req json(text) -> object
        //response object -> json(text)

        var objectMapper = new ObjectMapper();
        var user = new User();
        user.setName("steve");
        user.setAge(10);
        user.setPhoneNumber("010-1111-22222");

        try {
            //object -> text
            //object mapper get method를 활용한다.
            var text = objectMapper.writeValueAsString(user);
            System.out.println(text);

            //text -> object
            //object mapper default 생성자가 있어야 함
            var objectUser = objectMapper.readValue(text, User.class);
            System.out.println(objectUser);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



    }

}
