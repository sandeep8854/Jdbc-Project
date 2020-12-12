package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementInsertEmployeeTable 
{
	public static void main(String[] args) throws Exception
	{
		String Driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/Employees";
		String user="root";
		String pwd="root";
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		String sql_query="insert into employees values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql_query);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Employees Number ? ");
			int EmpNo=sc.nextInt();
			System.out.println("Enter Employees Name ? ");
			String Ename=sc.next();
			System.out.println("Enter Employees Salary ?");
			Double Esal=sc.nextDouble();
			System.out.println("Enter Employee Address ?");
			String Eaddr=sc.next();
			pst.setInt(1, EmpNo);
			pst.setString(2, Ename);
			pst.setDouble(3, Esal);
			pst.setString(4, Eaddr);
			
			pst.executeUpdate();
			System.out.println("Record Inserted Successfully ...");
			System.out.println("Do You Want To Insert One More Record [YES/NO] ");
			String option=sc.next();
			if(option.equalsIgnoreCase("NO"))
			{
				break;
			}
		}
		con.close();	
	}
}
/*
 * Enter Employees Number ? 
300
Enter Employees Name ? 
Pradeep
Enter Employees Salary ?
3000
Enter Employee Address ?
Agra
Record Inserted Successfully ...
Do You Want To Insert One More Record [YES/NO] 
yes
Enter Employees Number ? 
500
Enter Employees Name ? 
Shravan
Enter Employees Salary ?
5000
Enter Employee Address ?
Azamgarh
Record Inserted Successfully ...
Do You Want To Insert One More Record [YES/NO] 
NO
*/
