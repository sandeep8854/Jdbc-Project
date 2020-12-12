package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionAttackSimpleStatement 
{
	public static void main(String[] args) throws Exception
	{
		String Driver="com.mysql.jdbc.Driver";
		String sql_url="jdbc:mysql://localhost:3306/facebook";
		String user="root";
		String pwd="root";
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(sql_url, user, pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Name ? ");
		String UserName=sc.next();
		System.out.println("Enter Password ? ");
		String Password=sc.next();
		String sql_query="select count(*) from facebook where UserName='"+UserName+"' and Password='"+Password+"'";
		ResultSet rs=st.executeQuery(sql_query);
		int c=0;
		if(rs.next())
		{
			c=rs.getInt(1);
		}
		if(c==0)
			System.out.println("Invalid Credentials....");
		else
			System.out.println("Valid Credentials.....");
		con.close();
	}

}
