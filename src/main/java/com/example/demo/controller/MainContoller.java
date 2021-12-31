package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {
	@RequestMapping(value="/")
	public String index() {
		//System.out.println("hayeom");		
		return "index";
	}

}
