import java.sql.*;
public class App 
{
	public static void main(String[] args) 
	{
		try
		{
			//Loading driver class 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Creating connection object
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			System.out.println("Connected...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
