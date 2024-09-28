import java.sql.*;
import java.util.Scanner;
public class App2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			PreparedStatement ps=cn.prepareStatement("insert into employeeinfo values(?,?,?)");
			System.out.print("Enter employee id:");
			int eid=Integer.parseInt(sc.nextLine());
			ps.setInt(1,eid);
			System.out.print("Enter employee name:");
			String name=sc.nextLine();
			ps.setString(2,name);
			System.out.print("Enter employee salary:");
			int salary=Integer.parseInt(sc.nextLine());
			ps.setInt(3,salary);
			ps.executeUpdate();
			System.out.println("Record inserted...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
