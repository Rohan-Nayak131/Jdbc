package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//delete from student where sno=101;
public class DeleteTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		int sno=0;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter the sno you want to delete?");
				sno=sc.nextInt();
			}
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			if (con!=null) {
				st=con.createStatement();
			}
			query="delete from student where sno="+sno;
			if (st!=null) {
				count=st.executeUpdate(query);
			}
			if (count==0) {
				System.out.println("Record not deleted");
			} else {
				System.out.println("Record deleted "+count);
			}
			
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


