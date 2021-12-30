package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBAdaptor {
	private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2019";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	@Test
	public void connectionTest() throws Exception{
		Class.forName(Driver);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
