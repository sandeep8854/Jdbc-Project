package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NoSqlInjectionAttackPreparedStatement
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
		String sql_query="select count(*) from facebook where UserName=? and Password=?";
		PreparedStatement pst=con.prepareStatement(sql_query);
		pst.setString(1, UserName);
		pst.setString(2, Password);
		ResultSet rs=pst.executeQuery();
		int c=0;
		if(rs.next())
		{
			c=rs.getInt(1);
		}
		if(c==0)
			System.out.println("Invalid Credentials Your BadLuck..");
		else
			System.out.println("Valid Credentials Your Welcome ..");
		con.close();
		
		
		
	}

}
