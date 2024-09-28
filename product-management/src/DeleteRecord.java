import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class DeleteRecord 
{
	public JFrame frame=new JFrame("Delete Product Form");
	private JLabel label=new JLabel("Enter product id");
	private JTextField textbox=new JTextField(); 
	private JButton button=new JButton("Delete Record");
	private PreparedStatement ps;
	public DeleteRecord()
	{
		frame.setSize(600,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		ps=DbConnection.delete;
		addComponents();
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
	class DeleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			int pid=Integer.parseInt(textbox.getText());
			try
			{
				ps.setInt(1,pid);
				int n=ps.executeUpdate();
				if(n>=1)
				{
					JOptionPane.showMessageDialog(frame,"Product record has been deleted");
					textbox.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Product record does not exist");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
}
