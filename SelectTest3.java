//SelectTest3.java
//Write JDBC app to get emp details based on empno.
//QUERY::select empno,ename,job,sal from emp where empno=7900;
package com.nt.jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectTest3{
	public static void main(String [] args){
	
		Scanner sc=null;
		int empno=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		boolean flag=false;
		try
		{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter the Employee ID you want to see details");
				empno=sc.nextInt();
			}
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			if (con!=null)
				st=con.createStatement();
			query="select empno,ename,job,sal from emp where empno="+empno;
			System.out.println(query);
			if(st!=null)
				rs=st.executeQuery(query);
			if (rs!=null)
			{
				while(rs.next()){
				flag=true;
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getFloat(4));
				}
			}
			if(flag==false)
				System.out.println("No records displayed");
			else
				System.out.println("Record of "+empno+" is displayed");
		}
		catch (SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try
			{
				if(rs!=null)
					rs.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(st!=null)
					st.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(con!=null)
					con.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(sc!=null)
					sc.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		}
}