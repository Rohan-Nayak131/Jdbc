//Perform both Select and Non Select query operation



package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelect {

	public static void main(String[] args) {
		String query=null;
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		boolean flag=false;
		int count=0;
		try {
			
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter the query you want to perform on STUDENT table::");
				query=sc.nextLine();
			}
			//register jdbc driver---------->AutoLoading
			//Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//Execute query
			if(st!=null)
				flag=st.execute(query);//the return type of execute(-) is boolean....if true then it is a Select query.....if false then it is a non-select query
			if(flag) {
				System.out.println("SELECT query is executed");
				rs=st.getResultSet();
				//Process the result set
				if(rs!=null) {
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getFloat(4));
					}
				}
			}
			else {
				System.out.println("Non Select query is executed");
				count=st.getUpdateCount();
				System.out.println(count+" no. of records are affected");
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
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
