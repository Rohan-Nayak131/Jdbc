package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Write a JDBC App to display Employee details having minimum salary.

//SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP)
public class SelectTest6 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
	
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			if (con!=null) {
				st=con.createStatement();
			}
		
			if (st!=null) {
				rs=st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP)");
			}
			if (rs!=null) {
				while (rs.next()) {
					System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getFloat(4)); 
				}
			}
		} 
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
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
		}
	}

}
