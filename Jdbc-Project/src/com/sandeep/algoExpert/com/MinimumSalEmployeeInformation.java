package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MinimumSalEmployeeInformation 
{
	public static void main(String[] args) throws Exception
	{
		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/Employees";
		String user="root";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		String sql_query="select * from employees where esal in (select min(esal) from employees)";
		ResultSet rs=st.executeQuery(sql_query);
		if(rs.next())
		{
			System.out.println("Highest Salary Employees Information..");
			System.out.println("*************************************");
			System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t" +rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();
	}

}
