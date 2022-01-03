package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBAdaptor;
import com.example.demo.dto.DTO;

@RestController
public class RestConstroller {

	private DBAdaptor DB = new DBAdaptor();

	private void setDB(DBAdaptor DB) {
		this.DB = DB;
	}

	@ResponseBody
	@RequestMapping(value = "/click")
	public String click() {
		double result[] = new double[3];
		int execution_count = 10000;
		try {
			DB.connect();
		} catch (Exception e) {

		}
		result = DB.getProcedureExecutionStatistics(execution_count);
		DTO minmaxavg = new DTO();
		minmaxavg.setMin(result[0]);
		minmaxavg.setMax(result[1]);
		minmaxavg.setAvg(result[2]);
		//System.out.println("minmaxavg:" + minmaxavg);
		return "dd";
	}
}
