public class App2
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("AA");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
