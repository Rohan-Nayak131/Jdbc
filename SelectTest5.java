package com.nt.jdbc;
//Write a JDBC App to display Employee details having maximum salary.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)
public class SelectTest5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			if(con!=null)
				st=con.createStatement();
			query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
			System.out.println(query);
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null) {
				if(rs.next())
					System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getNString(3)+"     "+rs.getFloat(4));
				
			}
				
		} 
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
