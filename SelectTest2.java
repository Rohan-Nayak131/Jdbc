//SelectTest2.java
//select empno,ename,job,sal from emp where job in('CLERK','SALESMAN','MANAGER') order by job desc;
package com.nt.jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectTest2{
	public static void main(String [] args){
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		String cond=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		boolean flag=false;
	//read inputs
		try{
			sc=new Scanner(System.in);
			 if(sc!=null){
				 System.out.println("Enter  desg1");
				 desg1=sc.next().toUpperCase();//CLERK
				 System.out.println("Enter  desg2");
				 desg2=sc.next().toUpperCase();//SALESMAN
				 System.out.println("Enter  desg3");
				 desg3=sc.next().toUpperCase();//MANAGER
			 }//if
			cond="('CLERK','SALESMAN','MANAGER')";
			System.out.println(cond);
			//establish connection with DB s/w
		
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					  if(con!=null)
			//create statement object
						
						st=con.createStatement();

			//prepare query
			query="select empno,ename,job,sal from emp where job in "+cond+" order by job desc";
				if(st!=null)
				rs	=st.executeQuery(query);
					if(rs!=null){
							
							while(rs.next()){
								flag=true;
								System.out.println(rs.getInt("EMPNO")+"		"+rs.getString("ENAME")+"		"+rs.getFloat("SAL")+"		"+rs.getString("JOB"));
							}//while
					if(flag==false)
						System.out.println("No records found");
					else
						System.out.println("Records Displayed");
					}//if
		

		}//try
		catch(SQLException se){//handle known exception
			se.printStackTrace();
		}
		catch(Exception e){//handle unknown exception
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if (rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if (st!=null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if (con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if (sc!=null)
					sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
				
		}//finally	

	}//main
}//class