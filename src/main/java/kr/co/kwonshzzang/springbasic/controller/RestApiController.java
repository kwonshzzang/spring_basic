package kr.co.kwonshzzang.springbasic.controller;

import kr.co.kwonshzzang.springbasic.annotation.Decode;
import kr.co.kwonshzzang.springbasic.annotation.Timer;
import kr.co.kwonshzzang.springbasic.dto.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get_aop/{id}")
    public String  get(@PathVariable Long id, @RequestParam String name) {
//        System.out.println("get method");
//        System.out.println("get method : " + id);
//        System.out.println("get method : " + name);
        return id + " " + name;
    }

    @PostMapping("/post_aop")
    public UserInfo post(@RequestBody UserInfo userInfo) {
//        System.out.println("post method");
//        System.out.println("post method : " + userInfo);
        return userInfo;
    }

    @Timer
    @DeleteMapping("/delete_aop")
    public void delete() throws InterruptedException {
        Thread.sleep(1000 * 2);
    }

    @Decode
    @PutMapping("/put_aop")
    public UserInfo put(@RequestBody UserInfo userInfo) {
        System.out.println("put method");
        System.out.println("put method : " + userInfo);
        return userInfo;
    }
}
