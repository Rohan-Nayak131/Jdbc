//SelectTest4.java
//Write JDBC app to count number of emp records
//QUERY::select count(*) from emp;
package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest4{
	public static void main(String[] args){
	Connection con=null;
	Statement st=null;
	String query=null;
	ResultSet rs=null;
	

	try
	{
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		if(con!=null)
			st=con.createStatement();
		query="select count(*) from emp";
		if(st!=null)
			rs=st.executeQuery(query);
		if(rs!=null){
			if(rs.next()){
				System.out.println("The no of records found to be");
				System.out.println(rs.getInt(1));
			}
			else
				System.out.println("No records found");
		}
	}
	catch (SQLException se)
	{
		se.printStackTrace();
	}

	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally{
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
	}

	}//main
}//class
