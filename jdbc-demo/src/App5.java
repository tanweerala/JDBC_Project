import java.sql.*;
public class App5 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			Statement st=cn.createStatement();
			st.executeUpdate("update product set name='Mouse',price=1200 where pid=102");
			System.out.println("Record updated...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
