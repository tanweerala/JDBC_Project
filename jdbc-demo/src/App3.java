import java.sql.*;
public class App3 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			Statement st=cn.createStatement();
			st.executeUpdate("insert into product values(103,'Laptop',80000)");
			System.out.println("Record inserted...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
