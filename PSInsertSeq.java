package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSInsertSeq {																		// 1 2 3    1->nameCol    2->addrCol     3->avgCol
   private static final String  INSERT_STUD_QUERY="INSERT INTO STUDENT VALUES(STUD_SNO_SEQ.NEXTVAL,?,?,?)";//	rohan			bbsr		81.33
	public static void main(String[] args) {
		Scanner sc=null;
		int sno=0;
		String name=null,addrs=null;
		float avg=0.0f;
		Connection con=null;
		PreparedStatement ps=null;
		  int count=0;
		
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				
				System.out.println("Enter student name::");
				name=sc.next(); //gives ramesh
				System.out.println("Enter student address::");
				addrs=sc.next();  //gives delhi
				System.out.println("Enter student avg::");
				avg=sc.nextFloat();  //gives 56.77
			}
			
			//register jdbc driver s/w
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			    ps=con.prepareStatement(INSERT_STUD_QUERY);
			//set values to query params(?)
			if(ps!=null) {
				ps.setString(1,name);//rohan
				ps.setString(2, addrs);//bbsr
				ps.setFloat(3, avg);//81.33
			}
			
			//send and execute SQL query in Db s/w
			if(ps!=null)
				count=ps.executeUpdate();

			//process the 
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted ::"+ count);
			}//try
		catch(SQLException se) {
			if(se.getErrorCode()==12899)
				 System.out.println("u can not insert values more than column size");
			else if(se.getErrorCode()>=900 && se.getErrorCode()<=999) 
				System.out.println(" SQL Query Syntax problem");
			else
				System.out.println("unknow jdbc problem");
			
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
			    se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}//main
}//class
