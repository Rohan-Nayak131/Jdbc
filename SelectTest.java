//Write a jdbc app to perform select operation
//SelectTest.java
//QUERY=select * from student;
import java.sql.*; 
public class SelectTest
{



public static void main(String [] args)throws Exception{
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

	Statement st=con.createStatement();
	String query="select * from student";


	ResultSet rs=st.executeQuery(query);
	while (rs.next())
	{
		System.out.println(rs.getInt(1)+"     "+rs.getString(2)+"        "+rs.getString(3)+"        "+rs.getFloat(4));
	}//while
	rs.close();
	st.close();
	con.close();
	}//main
}//class


