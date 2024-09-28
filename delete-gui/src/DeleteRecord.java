import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class DeleteRecord 
{
	private JFrame frame=new JFrame("Delete Employee Form");
	private JLabel label=new JLabel("Enter employee id");
	private JTextField textbox=new JTextField(); 
	private JButton button=new JButton("Delete Record");
	private PreparedStatement ps;
	public DeleteRecord()
	{
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		addComponents();
		createConnection();
		frame.setVisible(true);
	}
	private void addComponents()
	{
		int y=50;
		Font font=new Font("arial",Font.PLAIN,22);
		Font font1=new Font("arial",Font.PLAIN,19);
		label.setBounds(50,150,250,30);
		label.setFont(font);
		frame.add(label);
		textbox.setBounds(300,150,250,30);
		textbox.setFont(font1);
		frame.add(textbox);
		button.setBounds(50,250,500,35);
		button.setFont(font1);
		frame.add(button);
		button.addActionListener(new DeleteListener());
	}
	private void createConnection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			ps=cn.prepareStatement("delete from employeeinfo where eid=?");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
	}
	class DeleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			int eid=Integer.parseInt(textbox.getText());
			try
			{
				ps.setInt(1,eid);
				int n=ps.executeUpdate();
				if(n>=1)
					JOptionPane.showMessageDialog(frame,"Record has been deleted");
				else
					JOptionPane.showMessageDialog(frame,"Record does not exist");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	public static void main(String[] args) 
	{
		new DeleteRecord();
	}
}
