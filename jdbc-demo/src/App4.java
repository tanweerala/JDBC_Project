import java.sql.*;
public class App4 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			Statement st=cn.createStatement();
			st.executeUpdate("delete from product where pid=101");
			System.out.println("Record deleted...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
