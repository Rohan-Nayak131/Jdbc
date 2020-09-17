//ConnTest.java
import java.sql.*; //jdbc api

public class ConnTest
{
	public static void main(String args[])throws Exception{
	//register jdbc driver s/w(oracle thin driver) with DriverManager service
				//create jdbc driver class object
						oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
					//<---package-------><-class------><var>				<constructor>
				//register jdbc driver
						DriverManager.registerDriver(driver);//static method
		//establish connection with DataBase s/w
			//Connection con=DriverManager.getConnection(url,db username,db pwd);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				
			//check connection
			if(con == null)
				System.out.println("Connection Failed");
			else
				System.out.println("Connection Successful");
			System.out.println("jdbc con object class name is "+con.getClass());
	}//main			
}//class