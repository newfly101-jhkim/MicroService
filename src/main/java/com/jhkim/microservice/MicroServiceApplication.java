package com.jhkim.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  // 이 클래스를 스프링 부트 서비스의 진입점으로 스프링 부트에 지정
@RestController         // 이 클래스의 코드를 Spring RestController로 노출하도록 스프링 부트에 지정
@RequestMapping(value="hello")      // 이 application에서 노출되는 모든 URL 앞에 /hello 가 붙는다
public class MicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }

    @GetMapping(value="/{firstName}")
    public String helloGET(
            @PathVariable("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}",firstName, lastName);
        // 직접 간단한 JSON 문자열을 만들어 반환한다.
    }

    @PostMapping
    public String helloPOST( @RequestBody HelloRequest request) {
        return String.format("{\"message\":\"Hello %s %s\"}",request.getFirstName(), request.getLastName());
    }
}

class HelloRequest{

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}