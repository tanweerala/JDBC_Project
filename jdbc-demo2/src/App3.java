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
			PreparedStatement st=cn.prepareStatement("insert into product values(?,?,?)");
			System.out.print("Enter product id:");
			int pid=Integer.parseInt(sc.nextLine());
			System.out.print("Enter product name:");
			String name=sc.nextLine();
			System.out.print("Enter product price:");
			int price=Integer.parseInt(sc.nextLine());
			st.setInt(1,pid);
			st.setString(2,name);
			st.setInt(3,price);
			st.executeUpdate();
			System.out.println("Record inserted...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
