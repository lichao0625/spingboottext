package com.example.spingboottext;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@SpringBootApplication
@Controller
@MapperScan("com.example.spingboottext.dao")
public class SpingboottextApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingboottextApplication.class, args);
    }
    @RequestMapping("/index")
    public String helloHtml(HashMap<String, Object> map) {
        return "/index";
    }
    @RequestMapping("/reg")
    public String reg(HashMap<String, Object> map) {
        return "/reg";
    }
}

