package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class RealWorldJdbc
{
	public static void main(String[] args) throws Exception 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con=null; 
		Statement st = null; 
		ResultSet rs=null;
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root", "root");
			st=con.createStatement();
			rs=st.executeQuery("select * from employees");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t" +rs.getDouble(3)+"\t"+rs.getString(4));
			}
		}
		catch(SQLDataException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();		
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
