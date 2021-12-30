package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String result() {
    	
    	float min = 0;
    	float max = 0;
    	float avg = 0;
    	String result = "max:"+max+"min:"+min+"avg"+avg;
        return result;
    }
}