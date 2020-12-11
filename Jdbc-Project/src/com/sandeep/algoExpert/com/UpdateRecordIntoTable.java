package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateRecordIntoTable 
{
	public static void main(String[] args) throws Exception 
	{
		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/employees";
		String user="root";
		String pwd="root";
		String sql_query="update employees set Esal=70000 where EmpNo=600";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		int updateCount=st.executeUpdate(sql_query);
		System.out.println("The Number Of Row Updated: " +updateCount);
		con.close();
	}
}
/*
The Number Of Row Updated 1
*/