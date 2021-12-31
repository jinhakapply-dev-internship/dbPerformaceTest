package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.db.DBAdaptor;

@Controller
public class MainContoller {
	
	private DBAdaptor DB;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/click")
	public String click() {
		double result[] = new double[3];
		int execution_count = 10000;
		result = DB.getProcedureExecutionStatistics(execution_count);
		String res_str = "max:"+result[0]+","+"min:"+result[1]+","+"avg:"+result[2];
		//System.out.println("hayeon");		
		return "res_str";
	}

}
