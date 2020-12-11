package com.sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMultipleRecordIntoTable 
{
	public static void main(String[] args) throws Exception
	{
		String driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/movies";
		String user="root";
		String pwd="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Movies Number ?");
			int MovieNO=sc.nextInt();
			System.out.println("Enter Actor Name ?");
			String MActor=sc.next();
			System.out.println("Enter Actress Name ?");
			String MActress=sc.next();
			System.out.println("Enter Movie Name ?");
			String MName=sc.next();
			
			String sql_querty=String.format("insert into movies values(%d,'%s','%s','%s')", MovieNO,MActor,MActress,MName);
			st.executeUpdate(sql_querty);
			System.out.println("Record Inserted Successfully....");
			System.out.println("Do You Want To Insert One More Records [YES/NO]");
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
Enter Movies Number ?
200
Enter Actor Name ?
AmirKhan
Enter Actress Name ?
Anushka
Enter Movie Name ?
PK
Record Inserted Successfully....
Do You Want To Insert One More Records [YES/NO]
yes
Enter Movies Number ?
300
Enter Actor Name ?
AliFajal
Enter Actress Name ?
SwetaTripathi
Enter Movie Name ?
Mirzapur
Record Inserted Successfully....
Do You Want To Insert One More Records [YES/NO]
no
*/