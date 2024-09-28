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
			PreparedStatement ps=cn.prepareStatement("delete from employeeinfo where eid=?");
			System.out.print("Enter employee id:");
			int eid=Integer.parseInt(sc.nextLine());
			ps.setInt(1,eid);
			int n=ps.executeUpdate();
			if(n>=1)
				System.out.println("Record deleted...");
			else
				System.out.println("Record does not exist...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		sc.close();
	}
}
