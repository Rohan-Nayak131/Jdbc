package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//update emp set sal=sal+(sal*0.2) where job='SALESMAN';
//Write a JDBC App to increase salary by 20% if the job name is salesman
public class UpdateTest2 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String job=null,query=null;
		Scanner sc=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter the job");
				job=sc.next();
				
				}
			job="'"+job+"'";
		//Register Driver s/w---->Auto loading
		//Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		//Create Statement object
			if(con!=null)
				st=con.createStatement();
			query="update emp set sal=sal+(sal*0.2) where job="+job;
			count=st.executeUpdate(query);
			if(count==0)
				System.out.println("record not updated");
			else
				System.out.println(count+" records updated");
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (st!=null) {
					st.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (con!=null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (sc!=null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
