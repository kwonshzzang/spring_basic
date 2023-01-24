package kr.co.kwonshzzang.springbasic.controller;

import kr.co.kwonshzzang.springbasic.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put/{userId}")
    public PutRequestDto put0(@PathVariable Long userId,  @RequestBody PutRequestDto requestDto) {
        System.out.println(userId);
        System.out.println(requestDto);
        return requestDto;
    }
}
