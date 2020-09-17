package com.nt.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//insert into emp(empno,ename,job,sal) values (567,'suresh','clerk',9000)
public class InsertTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		int empno=0;
		String ename=null,job=null,query=null;
		float sal=0.0f;
		Connection con=null;
		Statement st=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter empno");
				empno=sc.nextInt();
				System.out.println("Enter ename");
				ename=sc.next();
				System.out.println("Enter job");
				job=sc.next();
				System.out.println("Enter sal");
				sal=sc.nextFloat();
				}
			ename="'"+ename+"'";
			job="'"+job+"'";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			if(con!=null)
				st=con.createStatement();
			query="insert into emp(empno,ename,job,sal) values ("+empno+","+ename+","+job+","+sal+")";
			System.out.println(query);
			if(st!=null)
				count=st.executeUpdate(query);
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st!=null)
					st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
