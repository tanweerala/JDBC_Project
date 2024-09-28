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
			ResultSet rst=st.executeQuery("select * from employeeinfo");
			//Code to fetch/get/extract data from the resultset object
			rst.next();
			int v1=rst.getInt(1);
			String v2=rst.getString(2);
			String v3=rst.getString(3);
			int v4=rst.getInt(4);
			System.out.println("Id of employee is:"+v1);
			System.out.println("Name of employee is:"+v2);
			System.out.println("Dept of employee is:"+v3);
			System.out.println("Salary of employee is:"+v4);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
