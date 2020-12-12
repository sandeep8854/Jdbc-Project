package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AggregateFunCountNumOfRowPreInCol
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
		String sql_query="select count(*) from Employees";
		ResultSet rs=st.executeQuery(sql_query);
		if(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		con.close();
	}
}
