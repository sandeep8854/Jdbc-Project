package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectAndNonSelectQueByUsingExecuteMethod
{
	public static void main(String[] args) throws Exception
	{

		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/Employees";
		String user="root";
		String pwd="root";
		Class.forName(driver);  //this step is optional
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Query ? ?");
		String sqlquery=sc.nextLine();
		boolean b=st.execute(sqlquery);
		if(b==true) //select query
		{
			ResultSet rs=st.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t" +rs.getDouble(3)+"\t"+rs.getString(4));
			}
		}
		else
		{
			int rowCount=st.getUpdateCount();
			System.out.println("Number Of Record effected is: "+rowCount);
		}
		con.close();
	}
}
