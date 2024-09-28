import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRecord 
{
	public JFrame frame=new JFrame("Delete Employee Form");
	private JLabel label=new JLabel("Enter employee id");
	private JTextField textbox=new JTextField(); 
	private JButton button=new JButton("Show Record");
	private JButton update=new JButton("Update Record");
	private PreparedStatement ps1,ps2;
	private JPanel panel=new JPanel();
	JLabel[] heading=new JLabel[3];
	JTextField[] data=new JTextField[3];
	int pid;
	public UpdateRecord()
	{
		frame.setSize(600,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		ps1=DbConnection.search;
		ps2=DbConnection.update;
		addComponents();
		addPanel();
		frame.setVisible(true);
	}
	private void addComponents()
	{
		Font font=new Font("arial",Font.PLAIN,22);
		Font font1=new Font("arial",Font.PLAIN,19);
		label.setBounds(50,50,250,30);
		label.setFont(font);
		frame.add(label);
		textbox.setBounds(300,50,250,30);
		textbox.setFont(font1);
		frame.add(textbox);
		button.setBounds(50,120,500,35);
		button.setFont(font1);
		frame.add(button);
		button.addActionListener(new ShowListener());
		update.setBounds(50,420,500,35);
		update.setFont(font1);
		frame.add(update);
		update.setVisible(false);
		update.addActionListener(new UpdateListener());
	}
	private void addPanel()
	{
		panel.setBounds(50,200,500,200);
		panel.setBackground(Color.cyan);
		frame.add(panel);
		panel.setVisible(false);
		addResult();
	}
	private void addResult()
	{
		panel.setLayout(new GridLayout(3,2,0,50));
		Font font=new Font("Lucida Calligraphy",Font.BOLD,20);
		Font font1=new Font("arial",Font.PLAIN,20);
		String[] str= {"name","brand","price"};
		for(int i=0;i<3;i++)
		{
			heading[i]=new JLabel("Edit product "+str[i]);
			panel.add(heading[i]);
			heading[i].setFont(font);
			data[i]=new JTextField();
			panel.add(data[i]);
			data[i].setFont(font1);
			data[i].setForeground(Color.blue);
		}
	}
	class ShowListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			pid=Integer.parseInt(textbox.getText());
			try
			{
				ps1.setInt(1,pid);
				ResultSet rst=ps1.executeQuery();
				if(rst.next())
				{
					data[0].setText(rst.getString(2));
					data[1].setText(rst.getString(3));
					data[2].setText(rst.getString(4));
					panel.setVisible(true);
					update.setVisible(true);
				}
				else
				{
					panel.setVisible(false);
					update.setVisible(false);
					JOptionPane.showMessageDialog(frame,"Product record does exist");
				}
			}	
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	class UpdateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			try
			{
				ps2.setString(1,data[0].getText());
				ps2.setString(2,data[1].getText());
				ps2.setString(3,data[2].getText());
				ps2.setInt(4,pid);
				ps2.executeUpdate();
				panel.setVisible(false);
				update.setVisible(false);
				JOptionPane.showMessageDialog(frame,"Product record has been updated");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
}

