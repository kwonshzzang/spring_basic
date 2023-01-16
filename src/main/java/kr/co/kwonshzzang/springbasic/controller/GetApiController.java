package kr.co.kwonshzzang.springbasic.controller;

import kr.co.kwonshzzang.springbasic.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path="/hello")  //http://localhost:9090/api/get/hello
    public String hello() {
        return "get Hello";
    }
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get / post / put / delete
    public String hi() {
        return "hi";
    }

    //http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
    }

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmai.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey() + '=' + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println("name  : " + name);
        System.out.println("email : " + email);
        System.out.println("age   : " + age);
        return name + " " +  email + " " + age;
    }

    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println("name  : " + userRequest.getName());
        System.out.println("email : " + userRequest.getEmail());
        System.out.println("age   : " + userRequest.getAge());
        return userRequest.toString();
    }


}
