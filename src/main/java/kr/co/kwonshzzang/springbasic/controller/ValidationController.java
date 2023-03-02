package kr.co.kwonshzzang.springbasic.controller;

import jakarta.validation.Valid;
import kr.co.kwonshzzang.springbasic.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid  @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach( objectError -> {
                FieldError field = (FieldError)objectError;
                String message = objectError.getDefaultMessage();
                System.out.println("field : " + field.getField() );
                System.out.println(message);

                sb.append("field : " + field.getField() + "\n");
                sb.append("message : " + message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
