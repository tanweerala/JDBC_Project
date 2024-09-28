import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
public class ShowAllRecord 
{
	public JFrame frame=new JFrame("Showing All Records");
	private JTable table;
	private JScrollPane pane;
	private DefaultTableModel model=new DefaultTableModel();
	private Statement st;	
	public ShowAllRecord()
	{
		frame.setSize(600,500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		st=DbConnection.all;
		showResultSet();
		frame.setVisible(true);
	}
	private void showResultSet()
	{
		table=new JTable(model);
		pane=new JScrollPane(table);
		frame.add(pane);
		model.addColumn("Product id");
		model.addColumn("Product name");
		model.addColumn("Product brand");
		model.addColumn("Product price");
		try 
		{
			ResultSet rst=st.executeQuery("select * from productinfo");
			while(rst.next())
			{
				Object[] data= {rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)};
				model.addRow(data);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
