package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBAdaptor {
	private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2019";
	private static final String USER = "root";
	private static final String PW = "1234";

	DBAdaptor() throws Exception {
		Class.forName(Driver);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	private void executeProcedure() throws Exception {

	}


	private double getProcedureExecutionTime() throws Exception {
		double execute_time = 0.0;

		return execute_time;

	}

	public double[] getProcedureExecutionStatstics(int execution_time) {
		double min = 0.0;
		double max = 0.0;
		double avg = 0.0;

		double execution_info[] = new double[3];

		execution_info[0] = min;
		execution_info[1] = avg;
		execution_info[2] = max;

		return execution_info;
	}

}
