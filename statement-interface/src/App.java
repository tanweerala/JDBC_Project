import java.sql.*;
public class App 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			Statement st=cn.createStatement();
			st.execute("create table employeeinfo(eid int primary key,name varchar(20),salary int)");
			System.out.println("Table created...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
