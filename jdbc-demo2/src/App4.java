import java.sql.*;
import java.util.Scanner;
public class App4 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			PreparedStatement st=cn.prepareStatement("delete from product where pid=?");
			System.out.print("Enter product id:");
			int pid=sc.nextInt();
			st.setInt(1,pid);
			int n=st.executeUpdate();
			if(n>=1)
				System.out.println("Record deleted...");
			else
				System.out.println("Record does not exist...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
