package com.example.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용차가 요청 > 응답(html 파일) : @Controller
// 사용자가 요청 > 응답(data) : @RestController
@RestController
public class HttpControllerTest {
    // 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    // 하나씩 받을 때
//    public String getTest(@RequestParam int id, @RequestParam String username) {
//        return "get 요청 : " + id + ", " + username;
//    }

    // 한번에 받을 때
    public String getTest(Member m) { // id=1&username=ssar&password=1234&email=sasar.naver.com
        return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post")
    // x-www-form-urlencoded
//    public String postTest(Member m) {
//        return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//    }

    // raw Text : text/plain
//    public String postTest(@RequestBody String text) {
//        return "post 요청 : " + text;
//    }

    // raw JSON : application/json
    // MessageConverter(스프링부트) : {}안의 내용들을 자동으로 파싱 해줌
    public String postTest(@RequestBody Member m) {
        return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청" + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}