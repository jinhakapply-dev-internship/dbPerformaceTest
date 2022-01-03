package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;

//import org.junit.Test;

public class DBAdaptor {
	private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2019";
	private static final String USER = "root";
	private static final String PW = "1234";

	// JDBC Objects
	private Connection con = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;

	// Constants
	private static final double DOUBLE_MAX = 99999999999999.0;

	public DBAdaptor() {
	}

	public void connect() throws Exception {
		Class.forName(Driver);

		try {
			this.setCon(DriverManager.getConnection(URL, USER, PW));
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	// 프로시저 1회 실행
	private void executeProcedure() throws Exception {
		try {
			this.setCs(con.prepareCall("{call dbo.uspGetManagerEmployees(?)}"));

			int random_val = (int) (Math.random() * 15);
			cs.setInt(1, random_val);

			this.setRs(cs.executeQuery());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 프로시저 실행에 걸리는 시간을 계산한다
	private double getProcedureExecutionTime() throws Exception {

		long start = System.nanoTime();
		this.executeProcedure();
		long end = System.nanoTime();

		return (double) (end - start);
	}

	// 프로시저 실행 결과의 통계정보 리턴
	public double[] getProcedureExecutionStatistics(int execution_count) {
		double min = DBAdaptor.DOUBLE_MAX;
		double max = 0.0000000;
		double avg = 0.0000000;

		int i = 0;

		for (i = 0; i < execution_count; i++) {
			try {
				double exe_time = this.getProcedureExecutionTime() / 1000000.0; // ms로 단위 변환

				if (exe_time < min) {
					min = exe_time;

				}

				if (exe_time > max) {
					max = exe_time;
				}

				avg += exe_time;

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		double execution_info[] = new double[3];

		execution_info[0] = min;
		execution_info[1] = (avg / (double) execution_count);
		execution_info[2] = max;

		return execution_info;
	}


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the cs
	 */
	public CallableStatement getCs() {
		return cs;
	}

	/**
	 * @param cs the cs to set
	 */
	public void setCs(CallableStatement cs) {
		this.cs = cs;
	}

	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
