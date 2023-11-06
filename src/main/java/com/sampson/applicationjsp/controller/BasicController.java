package com.sampson.applicationjsp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicController {

    @RequestMapping("/test")
    public List<String> getTestValues(){
        return List.of("Test1","Test2","Test3","Test4","Test5","Test6");
    }
}
