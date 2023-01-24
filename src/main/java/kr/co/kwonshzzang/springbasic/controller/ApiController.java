package kr.co.kwonshzzang.springbasic.controller;

import kr.co.kwonshzzang.springbasic.dto.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //해당 클래스는 REST API를 처리하는 Controller
@RequestMapping("/api") //RequestMapping URI를 지정해 주는 Annotation
public class ApiController {

    @GetMapping("/hello")  //http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    //text
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //json
    //request -> object mapper -> object(user) -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
