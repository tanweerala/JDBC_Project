import java.sql.*;
public class App2 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			Statement st=cn.createStatement();
			st.execute("create table product(pid int primary key,name varchar(20),price int)");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
