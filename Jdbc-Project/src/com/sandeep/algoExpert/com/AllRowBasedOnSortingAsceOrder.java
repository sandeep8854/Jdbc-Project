package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllRowBasedOnSortingAsceOrder
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
		String sql_query="select * from employees order by Esal DESC";
		boolean flag=false;  //like a sandeep flag name
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("EmpNo\tEname\tEsal\tEaddr");
		System.out.println("********************************");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+ "\t" +rs.getString(2)+ "\t" +rs.getDouble(3)+ "\t"+rs.getString(4));
		}
		if(flag==false)
		{
			System.out.println("No Record Found ....");
		}
		con.close();
		
	}
}
/*
EmpNo	Ename	Esal	Eaddr
********************************
600	Harsh	70000.0	Agra
500	Rehan	50000.0	Bihar
500	Rehan	50000.0	Bihar
400	YashWardhan	40000.0	Bihar
300	Kiran	30000.0	AndhraPradesh
200	ShriKant	20000.0	AndhraPradesh
100	Sandeep	10000.0	UttarPradesh
*/