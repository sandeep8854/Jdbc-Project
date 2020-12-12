package com.sandeep.algoExpert.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NthHighestSalEmpInformation 
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number ? ?");
		int number=sc.nextInt();
		String sql_query="SELECT * FROM Employees Emp1 WHERE (number-1) = (SELECT COUNT(DISTINCT(Emp2.Salary)) FROM  Employees Emp2 WHERE Emp2.esal > Emp1.Salary)"+number;
		ResultSet rs=st.executeQuery(sql_query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t" +rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();
	}
}
