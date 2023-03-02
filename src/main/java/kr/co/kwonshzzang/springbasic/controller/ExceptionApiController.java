package kr.co.kwonshzzang.springbasic.controller;

import jakarta.validation.Valid;
import kr.co.kwonshzzang.springbasic.dto.exception.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exception")
public class ExceptionApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User(name, age);

        int a = 10 + age;
        return user;
    }

    @PostMapping
    public User post(@Valid  @RequestBody User user) {
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
