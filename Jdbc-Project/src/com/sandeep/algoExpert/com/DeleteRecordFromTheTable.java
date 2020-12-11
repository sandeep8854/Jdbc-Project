package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecordFromTheTable
{
	public static void main(String[] args) throws Exception
	{
		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/movies";
		String user="root";
		String pwd="root";
		String sql_query="Delete from movies where MovieNO=100";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		int count=st.executeUpdate(sql_query);
		System.out.println("The Number Of Row Deleted" +count);
		System.out.println("Table Created Successfully....");
		con.close();	
	}
}
