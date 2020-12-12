package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDeleteTheRow
{
	public static void main(String[] args) throws Exception
	{
		String Driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/Employees";
		String user="root";
		String pwd="root";
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		String sql_query="delete from employees where ename=?";
		PreparedStatement pst=con.prepareStatement(sql_query);
		pst.setString(1, "Rahul");
		int updateCount=pst.executeUpdate();
		System.out.println("The Number Of Row Deleted :" +updateCount);
		
		System.out.println("Reusing Prepared Statement To Delete One More Record");
		pst.setString(1, "Kiran");
		int updateCount1=pst.executeUpdate();
		System.out.println("The Number Of Row Deleted :" +updateCount1);
		con.close();
	}
}
