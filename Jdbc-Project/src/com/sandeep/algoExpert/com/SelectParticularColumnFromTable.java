package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectParticularColumnFromTable
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
		String sql_query="select Ename,Eaddr from employees";
		boolean flag=false;  //like a sandeep flag name
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("Ename\tEaddr");
		System.out.println("********************************");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getString(1)+  "\t" +rs.getString(2));
		}
		if(flag==false)
		{
			System.out.println("No Record Found ....");
		}
		con.close();
	}
}
/*
Ename	Eaddr
********************************
Sandeep	UttarPradesh
ShriKant	AndhraPradesh
Kiran	AndhraPradesh
YashWardhan	Bihar
Rehan	Bihar
Rehan	Bihar
Harsh	Agra
*/