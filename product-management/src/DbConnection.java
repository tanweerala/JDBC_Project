import java.sql.*;
public class DbConnection 
{
	public static PreparedStatement insert,delete,search,update;
	public static Statement all;
	public static void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2?createDatabaseIfNotExist=true","root","mysql");
			Statement st=cn.createStatement();
			st.execute("create table if not exists productinfo(pid int primary key,name varchar(30),brand varchar(30),price int)");
			insert=cn.prepareStatement("insert into productinfo values(?,?,?,?)");
			all=cn.createStatement();
			delete=cn.prepareStatement("delete from productinfo where pid=?");
			search=cn.prepareStatement("select * from productinfo where pid=?");
			update=cn.prepareStatement("update productinfo set name=?,brand=?,price=? where pid=?");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
