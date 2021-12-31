package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.db.DBAdaptor;
import com.example.demo.dto.DTO;


@Controller
public class MainContoller {
	
	private DBAdaptor DB;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/click")
	public DTO click() {
		double result[] = new double[3];
		int execution_count = 10000;
		result = DB.getProcedureExecutionStatistics(execution_count);
		DTO minmaxavg = new DTO();
		minmaxavg.setMin(result[0]);
		minmaxavg.setMax(result[1]);
		minmaxavg.setAvg(result[2]);
		System.out.println("minmaxavg:" + minmaxavg);		
		return minmaxavg;
	}

}
