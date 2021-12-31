package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.db.DBAdaptor;

@Controller
public class MainContoller {
	private DBAdaptor DB;
	@RequestMapping(value="/")
	public String index() {
		double result[] = new double[3];
		int execution_count = 10000;
		result = DB.getProcedureExecutionStatistics(execution_count);
		//System.out.println("hayeon");		
		return "index";
	}

}
