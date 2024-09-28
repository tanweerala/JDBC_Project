import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class InsertRecord2 
{
	private JFrame frame=new JFrame("Insert Employee Form");
	private JLabel[] label=new JLabel[4];
	private JTextField[] textbox=new JTextField[4]; 
	private JButton button=new JButton("Save Record");
	PreparedStatement ps;
	public InsertRecord2()
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
		String[] str= {"id","name","dept","salary"};
		int y=50;
		Font font=new Font("arial",Font.PLAIN,22);
		Font font1=new Font("arial",Font.PLAIN,19);
		for(int i=0;i<label.length;i++)
		{
			label[i]=new JLabel("Enter employee "+str[i]);
			label[i].setFont(font);
			label[i].setBounds(50,y,250,30);
			frame.add(label[i]);
			textbox[i]=new JTextField();
			textbox[i].setBounds(300,y,250,33);
			textbox[i].setFont(font1);
			textbox[i].setForeground(Color.blue);
			frame.add(textbox[i]);
			y+=70;
		}
		button.setBounds(50,350,500,35);
		button.setFont(font1);
		frame.add(button);
		button.addActionListener(new SaveListener());
	}
	public void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc2","root","mysql");
			ps=cn.prepareStatement("insert into employeeinfo values(?,?,?,?)");
		}
		catch(Exception ex)
		{
			System.out.println();
		}
	}
	class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				int eid=Integer.parseInt(textbox[0].getText());
				ps.setInt(1,eid);
				String name=textbox[1].getText();
				ps.setString(2,name);
				String dept=textbox[2].getText();
				ps.setString(3,dept);
				int salary=Integer.parseInt(textbox[3].getText());
				ps.setInt(4,salary);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(frame,"Record has been inserted");
				for(int i=0;i<4;i++)
					textbox[i].setText("");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	public static void main(String[] args) 
	{
		new InsertRecord2();
	}
}
