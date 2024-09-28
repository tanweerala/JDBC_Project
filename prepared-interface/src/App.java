import java.sql.*;
public class App 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			PreparedStatement ps=cn.prepareStatement("insert into employeeinfo values(?,?,?)");
			ps.setInt(1,101);
			ps.setString(2,"Amit Singh");
			ps.setInt(3,80000);
			ps.executeUpdate();
			System.out.println("Record inserted...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
