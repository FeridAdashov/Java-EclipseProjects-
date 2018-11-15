import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class Shopping extends JPanel implements ActionListener{

	static private JTable infotable = null;
	JScrollPane jcs;
	Object[][] data = null;
	JButton Goster, Delete, Delete_All, Adminstrator_Page, Main_Page;
	String[] head = null;
	
	public Shopping() {
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#7EDAE5"));
		
		Adminstrator_Page = new JButton("<-- Adminstrator_Page");
		Adminstrator_Page.setBounds(0, 0, 210, 25);
		Adminstrator_Page.setForeground(Color.decode("#884792"));
		Adminstrator_Page.setBackground(Color.decode("#70C680"));
		Adminstrator_Page.setFont(new Font("", Font.BOLD, 14));
		Adminstrator_Page.addActionListener(this);
		this.add(Adminstrator_Page);
		
		Main_Page = new JButton("<-- Main_Page");
		Main_Page.setBounds(0, 30, 210, 25);
		Main_Page.setForeground(Color.decode("#884792"));
		Main_Page.setBackground(Color.decode("#70C680"));
		Main_Page.setFont(new Font("", Font.BOLD, 14));
		Main_Page.addActionListener(this);
		this.add(Main_Page);
		
		Goster = new JButton("All_Statistics");
		Goster.setBounds(450, 5, 160, 33);
		Goster.setForeground(Color.BLUE);
		Goster.setBackground(Color.decode("#A0ECF5"));
		Goster.setFont(new Font("", Font.BOLD, 14));
		Goster.addActionListener(this);
		this.add(Goster);
		
		Delete = new JButton("Delete_Element");
		Delete.setBounds(300, 400, 160, 33);
		Delete.setForeground(Color.BLUE);
		Delete.setBackground(Color.decode("#A0ECF5"));
		Delete.setFont(new Font("", Font.BOLD, 14));
		Delete.addActionListener(this);
		this.add(Delete);
		
		Delete_All = new JButton("Delete_All");
		Delete_All.setBounds(650, 400, 160, 33);
		Delete_All.setForeground(Color.BLUE);
		Delete_All.setBackground(Color.decode("#A0ECF5"));
		Delete_All.setFont(new Font("", Font.BOLD, 14));
		Delete_All.addActionListener(this);
		this.add(Delete_All);
		
		jcs = new JScrollPane();
		jcs.setBounds(0, 80, 1100, 300);
		jcs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jcs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jcs.setBackground(Color.BLACK);
		this.add(jcs);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(Goster.getActionCommand()))
		{
			infotable = new JTable();
			try {
				Db_Properties properties = new Db_Properties();
				Connection connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				java.sql.Statement command = connection.createStatement();
				ResultSet out;
				
				out = command.executeQuery("SELECT COUNT(*) say FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SHOPPING'");
				out.next();
				int column_count = out.getInt("say");
				
				head = new String[column_count];
				
				out = command.executeQuery("SELECT * FROM user_tab_columns WHERE TABLE_NAME = 'SHOPPING'");
				for(int i = 0; i < column_count; ++i)
				{
					out.next();
					head[i] = out.getString("Column_Name");
				}
				
				out = command.executeQuery("SELECT COUNT(*) say FROM SHOPPING");
				out.next();
				data = new Object[out.getInt("say")][column_count];
				
				out = command.executeQuery("SELECT * FROM SHOPPING ORDER BY 1");
				int  i = 0;
				while(out.next())
				{
					for(int j = 0; j < column_count; ++j)
					{
						data[i][j] = out.getObject(head[j]);
					}
					++i;
				}
				connection.close();
			} catch (Exception e1) {
				System.out.println("Error happened to get data: " + e1.toString());
			}
			TableModel model = new DefaultTableModel(data, head)
			{
			  public boolean isCellEditable(int row, int column)
			  {
			    return false;
			  }
			};
			infotable.setModel(model);
			infotable.setBackground(Color.decode("#314D68"));
	        infotable.setFont(new Font("", Font.BOLD, 15));
	        infotable.setForeground(Color.WHITE);
	        infotable.setSelectionBackground(Color.WHITE);
	        infotable.setSelectionForeground(Color.RED);
	        jcs.setViewportView(infotable);
		}
		if(e.getActionCommand().equals(Delete.getActionCommand()))
		{
			try{
				Db_Properties properties = new Db_Properties();
				Connection connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				java.sql.Statement command = connection.createStatement();
				command.executeQuery("DELETE SHOPPING WHERE Shopping_Time = '" + infotable.getValueAt(infotable.getSelectedRow(), 0) + "'");
				command.executeQuery("COMMIT");
				connection.close();
				Goster.doClick();
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		if(e.getActionCommand().equals(Delete_All.getActionCommand()))
		{
			try{
				Db_Properties properties = new Db_Properties();
				Connection connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				java.sql.Statement command = connection.createStatement();
				command.executeQuery("TRUNCATE TABLE SHOPPING");
				connection.close();
				Goster.doClick();
			}catch(Exception e1)
			{
				
			}
		}
		if(e.getActionCommand().equals(Main_Page.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.mainWindow.setBounds(200, 100, 800, 500);
			BasePage.enter_page.setVisible(true);
		}
		if(e.getActionCommand().equals(Adminstrator_Page.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.mainWindow.setBounds(200, 100, 800, 500);
			BasePage.Admin.setVisible(true);
		}
	}

}
