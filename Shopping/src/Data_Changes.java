import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class Data_Changes extends JPanel implements ActionListener, ListSelectionListener{

	JButton Show_Data, Change_Data, Delete_Data, Delete_All_Data, Add_Data, Clear, Main_Page, Adminstrator_Page;
	JTable infotable;
	JLabel Product, Mehsulun_Adi, Mehsulun_Qiymeti, Ceki_Novu, Mehsulun_Miqdari, Ulduz;
	JTextField Enterproduct, mehsulun_Adi, mehsulun_Qiymeti, ceki_Novu, mehsulun_Miqdari;
	String[] head;
	Object[][] data;
	JScrollPane jcs;
	int selectedX = -1, selectedY = -1;
	JOptionPane op;
	Connection connection;
	java.sql.Statement command;
	ResultSet out;
	
	public Data_Changes() {
		
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#7D8C84"));
		op = new JOptionPane();
		
		Product = new JLabel("Product_Name");
		Product.setBounds(280, 12, 150, 20);
		Product.setForeground(Color.decode("#123C7D"));
		Product.setFont(new Font("", Font.BOLD, 15));
		this.add(Product);
		
		Enterproduct = new JTextField();
		Enterproduct.setBounds(420, 10, 160, 25);
		Enterproduct.setBackground(Color.decode("#ADC1C4"));
		Enterproduct.setForeground(Color.BLUE);
		Enterproduct.setFont(new Font("", Font.BOLD, 14));
		this.add(Enterproduct);
		
		Show_Data = new JButton("Search");
		Show_Data.setBounds(620, 8, 170, 30);
		Show_Data.setForeground(Color.BLUE);
		Show_Data.setBackground(Color.decode("#98DAB6"));
		Show_Data.setFont(new Font("", Font.BOLD, 14));
		Show_Data.addActionListener(this);
		this.add(Show_Data);
		
		Change_Data = new JButton("Change_Element");
		Change_Data.setBounds(10, 100, 200, 30);
		Change_Data.setForeground(Color.BLUE);
		Change_Data.setBackground(Color.decode("#98DAB6"));
		Change_Data.setFont(new Font("", Font.BOLD, 14));
		Change_Data.addActionListener(this);
		this.add(Change_Data);
		
		Delete_Data = new JButton("Delete_Element");
		Delete_Data.setBounds(10, 150, 200, 30);
		Delete_Data.setForeground(Color.BLUE);
		Delete_Data.setBackground(Color.decode("#98DAB6"));
		Delete_Data.setFont(new Font("", Font.BOLD, 14));
		Delete_Data.addActionListener(this);
		this.add(Delete_Data);
		
		Delete_All_Data = new JButton("Delete_All");
		Delete_All_Data.setBounds(10, 200, 200, 30);
		Delete_All_Data.setForeground(Color.BLUE);
		Delete_All_Data.setBackground(Color.decode("#98DAB6"));
		Delete_All_Data.setFont(new Font("", Font.BOLD, 14));
		Delete_All_Data.addActionListener(this);
		this.add(Delete_All_Data);
		
		Add_Data = new JButton("Add");
		Add_Data.setBounds(230, 280, 150, 30);
		Add_Data.setForeground(Color.BLUE);
		Add_Data.setBackground(Color.decode("#98DAB6"));
		Add_Data.setFont(new Font("", Font.BOLD, 14));
		Add_Data.addActionListener(this);
		this.add(Add_Data);
		
		Clear = new JButton("Refresh");
		Clear.setBounds(430, 280, 120, 30);
		Clear.setForeground(Color.BLUE);
		Clear.setBackground(Color.decode("#98DAB6"));
		Clear.setFont(new Font("", Font.BOLD, 13));
		Clear.addActionListener(this);
		this.add(Clear);
		
		Mehsulun_Adi = new JLabel("Product_Name");
		Mehsulun_Adi.setBounds(230, 320, 150, 20);
		Mehsulun_Adi.setForeground(Color.decode("#123C7D"));
		Mehsulun_Adi.setFont(new Font("", Font.BOLD, 15));
		this.add(Mehsulun_Adi);
		
		mehsulun_Adi = new JTextField();
		mehsulun_Adi.setText("");
		mehsulun_Adi.setBounds(430, 320, 120, 25);
		mehsulun_Adi.setBackground(Color.decode("#ADC1C4"));
		mehsulun_Adi.setForeground(Color.BLUE);
		mehsulun_Adi.setFont(new Font("", Font.BOLD, 14));
		this.add(mehsulun_Adi);
		
		Mehsulun_Qiymeti = new JLabel("Price");
		Mehsulun_Qiymeti.setBounds(230, 360, 150, 20);
		Mehsulun_Qiymeti.setForeground(Color.decode("#123C7D"));
		Mehsulun_Qiymeti.setFont(new Font("", Font.BOLD, 15));
		this.add(Mehsulun_Qiymeti);
		
		mehsulun_Qiymeti = new JTextField();
		mehsulun_Qiymeti.setText("");
		mehsulun_Qiymeti.setBounds(430, 360, 120, 25);
		mehsulun_Qiymeti.setBackground(Color.decode("#ADC1C4"));
		mehsulun_Qiymeti.setForeground(Color.BLUE);
		mehsulun_Qiymeti.setFont(new Font("", Font.BOLD, 14));
		this.add(mehsulun_Qiymeti);
		
		Ceki_Novu = new JLabel("Weight_Type");
		Ceki_Novu.setBounds(230, 400, 150, 20);
		Ceki_Novu.setForeground(Color.decode("#123C7D"));
		Ceki_Novu.setFont(new Font("", Font.BOLD, 15));
		this.add(Ceki_Novu);
		
		ceki_Novu = new JTextField();
		ceki_Novu.setText("");
		ceki_Novu.setBounds(430, 400, 120, 25);
		ceki_Novu.setBackground(Color.decode("#ADC1C4"));
		ceki_Novu.setForeground(Color.BLUE);
		ceki_Novu.setFont(new Font("", Font.BOLD, 14));
		this.add(ceki_Novu);
		
		Mehsulun_Miqdari = new JLabel("Amount");
		Mehsulun_Miqdari.setBounds(230, 440, 150, 20);
		Mehsulun_Miqdari.setForeground(Color.decode("#123C7D"));
		Mehsulun_Miqdari.setFont(new Font("", Font.BOLD, 15));
		this.add(Mehsulun_Miqdari);
		
		mehsulun_Miqdari = new JTextField();
		mehsulun_Miqdari.setText("");
		mehsulun_Miqdari.setBounds(430, 440, 120, 25);
		mehsulun_Miqdari.setBackground(Color.decode("#ADC1C4"));
		mehsulun_Miqdari.setForeground(Color.BLUE);
		mehsulun_Miqdari.setFont(new Font("", Font.BOLD, 14));
		this.add(mehsulun_Miqdari);
		
		Ulduz = new JLabel("*");
		Ulduz.setBounds(560, 320, 150, 20);
		Ulduz.setForeground(Color.RED);
		Ulduz.setFont(new Font("", Font.BOLD, 20));
		this.add(Ulduz);
		
		Ulduz = new JLabel("*");
		Ulduz.setBounds(560, 360, 150, 20);
		Ulduz.setForeground(Color.RED);
		Ulduz.setFont(new Font("", Font.BOLD, 20));
		this.add(Ulduz);
		
		Ulduz = new JLabel("*");
		Ulduz.setBounds(560, 400, 150, 20);
		Ulduz.setForeground(Color.RED);
		Ulduz.setFont(new Font("", Font.BOLD, 20));
		this.add(Ulduz);
		
		Ulduz = new JLabel("*");
		Ulduz.setBounds(560, 440, 150, 20);
		Ulduz.setForeground(Color.RED);
		Ulduz.setFont(new Font("", Font.BOLD, 20));
		this.add(Ulduz);
		
		jcs = new JScrollPane();
		jcs.setBounds(280, 80, 510, 170);
		jcs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jcs.setBackground(Color.BLACK);
		this.add(jcs);
		
		Adminstrator_Page = new JButton("<-- Adminstrator_Page");
		Adminstrator_Page.setBounds(10, 0, 200, 27);
		Adminstrator_Page.setForeground(Color.decode("#884792"));
		Adminstrator_Page.setBackground(Color.decode("#70C680"));
		Adminstrator_Page.setFont(new Font("", Font.BOLD, 14));
		Adminstrator_Page.addActionListener(this);
		this.add(Adminstrator_Page);
		
		Main_Page = new JButton("<-- Main_Page");
		Main_Page.setBounds(10, 30, 200, 27);
		Main_Page.setForeground(Color.decode("#884792"));
		Main_Page.setBackground(Color.decode("#70C680"));
		Main_Page.setFont(new Font("", Font.BOLD, 14));
		Main_Page.addActionListener(this);
		this.add(Main_Page);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(Show_Data.getActionCommand()))
		{
			selectedX = -1;
			selectedY = -1;
			infotable = new JTable();
			try {
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				out = command.executeQuery("SELECT COUNT(*) say FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PRODUCT_INFO'");
				out.next();
				int column_count = out.getInt("say");
				head = new String[column_count];
				
				out = command.executeQuery("SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PRODUCT_INFO'");
				for(int i = 0; i < column_count; ++i)
				{
					out.next();
					head[i] = out.getString("Column_Name");
				}
				
				out = command.executeQuery("SELECT COUNT(*) say FROM PRODUCT_INFO"
						+ " WHERE LOWER(MEHSULUN_ADI) LIKE '%" + Enterproduct.getText().toLowerCase() + "%'");
				out.next();
				data = new Object[out.getInt("say")][column_count];
				
				out = command.executeQuery("SELECT * FROM PRODUCT_INFO "
						+ "WHERE LOWER(MEHSULUN_ADI) LIKE '%" + Enterproduct.getText().toLowerCase() + "%'");
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
			infotable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			infotable.setBackground(Color.decode("#314D68"));
	        infotable.setFont(new Font("", Font.BOLD, 15));
	        infotable.setForeground(Color.WHITE);
	        infotable.setSelectionBackground(Color.WHITE);
	        infotable.setSelectionForeground(Color.RED);
	        ListSelectionModel listmodel = infotable.getSelectionModel();
	        listmodel.addListSelectionListener(this);
	        jcs.setViewportView(infotable);
		}
		
		if(e.getActionCommand().equals(Change_Data.getActionCommand()) && selectedX != -1)
		{
			try{
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				Object new_el = op.showInputDialog("Yeni " + infotable.getColumnName(selectedX));
				
				command.executeQuery("UPDATE PRODUCT_INFO SET "
				+ infotable.getColumnName(selectedX) + " = '" + new_el + "' WHERE MEHSULUN_ADI = '"
				+ infotable.getValueAt(selectedY, 0) + "' AND MEHSULUN_QIYMETI = "
				+ infotable.getValueAt(selectedY, 1) + "  AND CEKI_NOVU = '"
				+ infotable.getValueAt(selectedY, 2) + "' AND QALAN_MIQDAR = "
				+ infotable.getValueAt(selectedY, 3));
				
				selectedX = -1;
				command.execute("COMMIT");
				connection.close();
				Show_Data.doClick();
			}catch(Exception e1){}
		}
		
		if(e.getActionCommand().equals(Delete_Data.getActionCommand()) && selectedX != -1)
		{
			try {
				Db_Properties properties = new Db_Properties();
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				
				command.execute("DELETE PRODUCT_INFO WHERE MEHSULUN_ADI = '" 
				+ infotable.getValueAt(selectedY, 0) 
				+ "' AND MEHSULUN_QIYMETI = "
				+ infotable.getValueAt(selectedY, 1) + "  AND CEKI_NOVU = '"
				+ infotable.getValueAt(selectedY, 2) + "' AND QALAN_MIQDAR = "
				+ infotable.getValueAt(selectedY, 3));
				
				command.execute("COMMIT");
				connection.close();
				Show_Data.doClick();
			} catch (SQLException e1) {}
		}
		
		if(e.getActionCommand().equals(Delete_All_Data.getActionCommand()))
		{
			try {
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				command.execute("DElETE PRODUCT_INFO");
				command.execute("COMMIT");
				connection.close();
				Show_Data.doClick();
			} catch (Exception e1) {}
		}
		
		if(e.getActionCommand().equals(Add_Data.getActionCommand()))
		{
			if(!mehsulun_Adi.getText().equals("") && !mehsulun_Qiymeti.getText().equals("")
					&& !ceki_Novu.getText().equals("") && !mehsulun_Miqdari.getText().equals(""))
			{
				try {
					Db_Properties properties = new Db_Properties();
					Class.forName(properties.getDriver());
					connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
					command = connection.createStatement();
					ResultSet out = command.executeQuery("SELECT COUNT(1) say FROM PRODUCT_INFO WHERE "
							+ "MEHSULUN_ADI = '"+ mehsulun_Adi.getText().trim() + "' AND CEKI_NOVU = '" +
							ceki_Novu.getText().trim() + 
							"' AND MEHSULUN_QIYMETI = " + mehsulun_Qiymeti.getText().trim());
					
					out.next();
					if(out.getInt("say") == 0){
						command.executeQuery("INSERT INTO PRODUCT_INFO"
							+ " VALUES('" + mehsulun_Adi.getText().toLowerCase().trim() + "' , " +
							Double.parseDouble(mehsulun_Qiymeti.getText().trim()) + " , '" + 
							ceki_Novu.getText().toLowerCase().trim() + "' , " +
							Double.parseDouble(mehsulun_Miqdari.getText().trim()) + ")");
					}
					
					else if(out.getInt("say") == 1)
					{
						out = command.executeQuery("SELECT QALAN_MIQDAR FROM PRODUCT_INFO WHERE "
							+ "MEHSULUN_ADI = '"+ mehsulun_Adi.getText().trim() + "' AND CEKI_NOVU = '" +
							ceki_Novu.getText().trim() + 
							"' AND MEHSULUN_QIYMETI = " + mehsulun_Qiymeti.getText().trim());
						out.next();
						
						command.executeQuery("UPDATE PRODUCT_INFO SET QALAN_MIQDAR = " + (out.getDouble("QALAN_MIQDAR") + Double.parseDouble(mehsulun_Miqdari.getText()))
						+ " WHERE MEHSULUN_ADI = '"+ mehsulun_Adi.getText().trim() + "' AND CEKI_NOVU = '" + ceki_Novu.getText().trim() + "'");
					}
					
					command.execute("COMMIT");
					connection.close();
					Show_Data.doClick();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		if(e.getActionCommand().equals(Clear.getActionCommand()))
		{
			mehsulun_Adi.setText("");
			mehsulun_Qiymeti.setText("");
			ceki_Novu.setText("");
			mehsulun_Miqdari.setText("");
		}
		
		if(e.getActionCommand().equals(Main_Page.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.enter_page.setVisible(true);
		}
		if(e.getActionCommand().equals(Adminstrator_Page.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.Admin.setVisible(true);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		selectedX = infotable.getSelectedColumn();
		selectedY = infotable.getSelectedRow();
		
	}

}
