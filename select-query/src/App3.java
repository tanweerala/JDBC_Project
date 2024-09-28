import java.sql.*;
import java.util.Scanner;
public class App3 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			PreparedStatement ps=cn.prepareStatement("select * from employeeinfo where eid=?");
			System.out.print("Enter employee id:");
			int eid=sc.nextInt();
			ps.setInt(1,eid);
			ResultSet rst=ps.executeQuery();
			if(rst.next())
			{
				int v1=rst.getInt(1);
				String v2=rst.getString(2);
				String v3=rst.getString(3);
				int v4=rst.getInt(4);
				System.out.println("Id of employee is:"+v1);
				System.out.println("Name of employee is:"+v2);
				System.out.println("Dept of employee is:"+v3);
				System.out.println("Salary of employee is:"+v4);
				System.out.println("--------------------------");
			}
			else
			{
				System.out.println("Record not found");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
