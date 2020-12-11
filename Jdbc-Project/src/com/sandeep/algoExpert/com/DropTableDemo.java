package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTableDemo 
{
	public static void main(String[] args) throws Exception
	{
		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/movies";
		String user="root";
		String pwd="root";
		String sql_query="drop tables movies";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		st.executeUpdate(sql_query);
		System.out.println("Table Created Successfully....");
		con.close();
		
	}

}
