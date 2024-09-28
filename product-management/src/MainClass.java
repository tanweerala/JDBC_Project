import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainClass
{
	JFrame frame=new JFrame("Product management systems");
	JButton[] bt=new JButton[5];
	public MainClass()
	{
		frame.setSize(600,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		DbConnection.createConnection();
		addButtons();
		frame.setVisible(true);
	}
	private void addButtons()
	{
		frame.setLayout(null);
		int y=60;
		String[] str= {"Insert","Delete","Show all","Update","Search"};
		Font fo=new Font("arial",Font.PLAIN,20);
		MenuListener listener=new MenuListener();
		for(int i=0;i<5;i++)
		{
			bt[i]=new JButton(str[i]+" record");
			bt[i].setBounds(200,y,200,35);
			bt[i].setFont(fo);
			bt[i].addActionListener(listener);
			frame.add(bt[i]);
			y+=75;
		}
	}
	class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(bb==bt[0])//Insert record
			{
				new InsertRecord();
			}
			else if(bb==bt[1])//Delete record
			{
				new DeleteRecord();
			}
			else if(bb==bt[2])//Show all record
			{
				new ShowAllRecord();
			}
			else if(bb==bt[3])//Update record
			{
				new UpdateRecord();
			}
			else if(bb==bt[4])//Search record
			{
				new SearchRecord();
			}
		}
	}
	public static void main(String[] args) 
	{
		new MainClass();
	}
}
