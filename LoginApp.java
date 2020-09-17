package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Simple Login Application
//select count(*) from usrinfo where uname='raja' and pwd='rani';
public class LoginApp {
		public static void main(String[] args) {
			Scanner sc=null;
			String uname=null;
			String pwd=null;
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			String query=null;
			int count=0;
			
			try {
				sc=new Scanner(System.in);
				if(sc!=null) {
					System.out.println("Enter USERNAME");
					uname=sc.next();
					System.out.println("Enter PASSWORD");
					pwd=sc.next();
				}
				//convert java string to sql string
				uname="'"+uname+"'";
				pwd="'"+pwd+"'";
				//register driver s/w--->autoloading form jdbc 4.0V
				//Connection between JAVA APP and DB s/w
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
				if(con!=null)
					st=con.createStatement();
				query="select count(*) from usrinfo where uname="+uname+" and pwd="+pwd;
				rs=st.executeQuery(query);
				if(rs!=null) {
					while(rs.next()) {
						count=rs.getInt(1);
					}
					if(count==0)
						System.out.println("Invalid Credentials");
					else
						System.out.println("Valid Credentials");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
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
