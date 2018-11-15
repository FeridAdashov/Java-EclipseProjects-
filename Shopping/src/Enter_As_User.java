import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
public class Enter_As_User extends JPanel implements ActionListener, ListSelectionListener{

	static private JTable infotable = null;
	JScrollPane jcs;
	String[] head;
	Object[][] data;
	JLabel product, amount, answer, qaytarilacaq_mebleg, kesr_mebleg, alinan_mebleg, qaytarilacaqmebleg, kesrmebleg;
	JButton search, hesabla, hesabla2, refresh, ana_sehife;
	JTextField enterproduct, enteramount, Alinan_Mebleg;
	static private double price = 0.0, saxtaqiymet = 0.0;
	static String mehsul_ad, ceki_nov;
	Connection connection;
	Statement command;
	
	public Enter_As_User() {
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#7EDAE5"));
		
		refresh = new JButton("Refresh");
		refresh.setBounds(345, 5, 160, 33);
		refresh.setForeground(Color.BLUE);
		refresh.setBackground(Color.decode("#A0ECF5"));
		refresh.setFont(new Font("", Font.BOLD, 14));
		refresh.addActionListener(this);
		this.add(refresh);
		
		ana_sehife = new JButton("Main_Page");
		ana_sehife.setBounds(0, 0, 165, 33);
		ana_sehife.setForeground(Color.RED);
		ana_sehife.setBackground(Color.decode("#80DDE6"));
		ana_sehife.setFont(new Font("", Font.BOLD, 16));
		ana_sehife.addActionListener(this);
		this.add(ana_sehife);
		
		product = new JLabel("Product_Name");
		product.setBounds(20, 75, 150, 20);
		product.setForeground(Color.decode("#123C7D"));
		product.setFont(new Font("", Font.BOLD, 15));
		this.add(product);
		
		enterproduct = new JTextField();
		enterproduct.setBounds(140, 75, 160, 25);
		enterproduct.setBackground(Color.decode("#ADC1C4"));
		enterproduct.setForeground(Color.BLUE);
		enterproduct.setFont(new Font("", Font.BOLD, 14));
		this.add(enterproduct);
		
		search = new JButton("Search");
		search.setBounds(310, 75, 100, 25);
		search.setForeground(Color.BLUE);
		search.setBackground(Color.decode("#A0ECF5"));
		search.setFont(new Font("", Font.BOLD, 14));
		search.addActionListener(this);
		this.add(search);
		
        jcs = new JScrollPane();
		jcs.setBounds(20, 145, 395, 160);
		jcs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jcs.setBackground(Color.BLACK);
		this.add(jcs);
		
		amount = new JLabel("Amount");
		amount.setBounds(440, 75, 150, 20);
		amount.setForeground(Color.decode("#123C7D"));
		amount.setFont(new Font("", Font.BOLD, 15));
		this.add(amount);
		
		enteramount = new JTextField("");
		enteramount.setBounds(520, 75, 160, 25);
		enteramount.setBackground(Color.decode("#ADC1C4"));
		enteramount.setForeground(Color.BLUE);
		enteramount.setFont(new Font("", Font.BOLD, 14));
		this.add(enteramount);
		
		hesabla = new JButton("Calculate");
		hesabla.setBounds(690, 75, 100, 25);
		hesabla.setActionCommand("hesabla1");
		hesabla.setForeground(Color.BLUE);
		hesabla.setBackground(Color.decode("#A0ECF5"));
		hesabla.setFont(new Font("", Font.BOLD, 14));
		hesabla.addActionListener(this);
		this.add(hesabla);
		
		answer = new JLabel("Sum: ");
		answer.setBounds(440, 145, 150, 20);
		answer.setForeground(Color.decode("#123C7D"));
		answer.setFont(new Font("", Font.BOLD, 15));
		this.add(answer);
		
		qaytarilacaq_mebleg = new JLabel("Change:");
		qaytarilacaq_mebleg.setBounds(250, 400, 200, 20);
		qaytarilacaq_mebleg.setForeground(Color.decode("#123C7D"));
		qaytarilacaq_mebleg.setFont(new Font("", Font.BOLD, 15));
		this.add(qaytarilacaq_mebleg);
		
		qaytarilacaqmebleg = new JLabel("");
		qaytarilacaqmebleg.setBounds(430, 400, 200, 20);
		qaytarilacaqmebleg.setForeground(Color.decode("#123C7D"));
		qaytarilacaqmebleg.setFont(new Font("", Font.BOLD, 15));
		this.add(qaytarilacaqmebleg);
		
		kesr_mebleg = new JLabel("Customer_Debt:");
		kesr_mebleg.setBounds(250, 450, 150, 20);
		kesr_mebleg.setForeground(Color.decode("#123C7D"));
		kesr_mebleg.setFont(new Font("", Font.BOLD, 15));
		this.add(kesr_mebleg);
		
		kesrmebleg = new JLabel("");
		kesrmebleg.setBounds(430, 450, 150, 20);
		kesrmebleg.setForeground(Color.decode("#123C7D"));
		kesrmebleg.setFont(new Font("", Font.BOLD, 15));
		this.add(kesrmebleg);
		
		alinan_mebleg = new JLabel("Money:");
		alinan_mebleg.setBounds(250, 350, 150, 20);
		alinan_mebleg.setForeground(Color.decode("#123C7D"));
		alinan_mebleg.setFont(new Font("", Font.BOLD, 15));
		this.add(alinan_mebleg);
		
		Alinan_Mebleg = new JTextField();
		Alinan_Mebleg.setText("");
		Alinan_Mebleg.setBounds(430, 350, 160, 25);
		Alinan_Mebleg.setBackground(Color.decode("#ADC1C4"));
		Alinan_Mebleg.setForeground(Color.BLUE);
		Alinan_Mebleg.setFont(new Font("", Font.BOLD, 14));
		this.add(Alinan_Mebleg);
		
		hesabla2 = new JButton("Calculate");
		hesabla2.setBounds(600, 350, 100, 25);
		hesabla2.setActionCommand("hesabla2");
		hesabla2.setForeground(Color.BLUE);
		hesabla2.setBackground(Color.decode("#A0ECF5"));
		hesabla2.setFont(new Font("", Font.BOLD, 14));
		hesabla2.addActionListener(this);
		this.add(hesabla2);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawLine(420, 40, 420, 305);
		g.drawLine(0, 305, 800, 305);
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(search.getActionCommand()))
		{
			infotable = new JTable();
			try {
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				ResultSet out;
				command = connection.createStatement();
				out = command.executeQuery("SELECT COUNT(*) say FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PRODUCT_INFO'");
				out.next();
				int column_count = out.getInt("say");
				column_count--;
				head = new String[column_count];
				
				out = command.executeQuery("SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'PRODUCT_INFO'");
				for(int i = 0; i < column_count; ++i)
				{
					out.next();
					head[i] = out.getString("Column_Name");
				}
				
				out = command.executeQuery("SELECT COUNT(*) say FROM PRODUCT_INFO"
						+ " WHERE MEHSULUN_ADI LIKE '%" + enterproduct.getText().toLowerCase() + "%'");
				out.next();
				data = new Object[out.getInt("say")][column_count];
				
				out = command.executeQuery("SELECT * FROM PRODUCT_INFO "
						+ "WHERE MEHSULUN_ADI LIKE '%" + enterproduct.getText().toLowerCase() + "%'");
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
				//System.out.println("Error happened to get data: " + e1.toString());
				e1.printStackTrace();
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
	        ListSelectionModel listmodel = infotable.getSelectionModel();
	        listmodel.addListSelectionListener(this);
	        jcs.setViewportView(infotable);
	        
		}
		
		if(e.getActionCommand().equals(hesabla.getActionCommand()) && !enteramount.getText().equals("") && !answer.getText().equals(""))
		{
			Double qalan = null;
			try{
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				ResultSet out = command.executeQuery("SELECT QALAN_MIQDAR FROM PRODUCT_INFO WHERE MEHSULUN_ADI = '"
						+ mehsul_ad + "' and CEKI_NOVU = '" + ceki_nov + "'");
				out.next();
				qalan = out.getDouble("QALAN_MIQDAR");
				connection.close();
			}catch(Exception e1){
				System.out.println(e1.toString());
			}
			
			try{
				if(qalan != 0)
				{
					saxtaqiymet = price;
					try{
						saxtaqiymet *= Double.parseDouble((enteramount.getText()));
						if(saxtaqiymet < 0) saxtaqiymet = -saxtaqiymet;
					}catch(Exception ex)
					{
						saxtaqiymet = 0.0;
					}
					
					saxtaqiymet = (double) Math.ceil((saxtaqiymet * 10)) / 10;
					answer.setText("Sum: " + saxtaqiymet + "0");
				}
				else{
					new JOptionPane().showMessageDialog(null, "No Enough Product");
				}
			}catch(Exception e2)
			{
				System.out.println(e2.toString());
			}
		}
		
		if(e.getActionCommand().equals(hesabla2.getActionCommand()))
		{
			if(Alinan_Mebleg.getText().equals(""))
			{
				kesrmebleg.setText(((Double)saxtaqiymet).toString());
				qaytarilacaqmebleg.setText("0.0");
			}
			else{
				Double alinan = Double.parseDouble(Alinan_Mebleg.getText());
				if(alinan == saxtaqiymet)
				{
					kesrmebleg.setText("0.0");
					qaytarilacaqmebleg.setText("0.0");
				}
				if(alinan > saxtaqiymet)
				{
					kesrmebleg.setText("0.0");
					Double d = (double) Math.round((alinan - saxtaqiymet) * 100) / 100;
					d = (double) Math.floor((d * 10)) / 10;
					qaytarilacaqmebleg.setText(d + "0");
				}
				if(alinan < saxtaqiymet)
				{
					qaytarilacaqmebleg.setText("0.0");
					Double d = (double) Math.round((saxtaqiymet - alinan) * 100) / 100;
					d = (double) Math.ceil((d * 10)) / 10;
					kesrmebleg.setText(d + "0");
				}
				
				try {
					Db_Properties properties = new Db_Properties();
					Class.forName(properties.getDriver());
					connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
					command = connection.createStatement();
					
					ResultSet out = command.executeQuery("SELECT QALAN_MIQDAR FROM PRODUCT_INFO WHERE MEHSULUN_ADI = '"
							+ infotable.getValueAt(infotable.getSelectedRow(), 0) + "' "
							+ " AND CEKI_NOVU = '" + infotable.getValueAt(infotable.getSelectedRow(), 2) + "'");
					out.next();
					Double qalan = out.getDouble("QALAN_MIQDAR");
					
					command.execute("UPDATE PRODUCT_INFO SET QALAN_MIQDAR = " + (qalan - Double.parseDouble(enteramount.getText()))
							+ " WHERE MEHSULUN_ADI = '" + infotable.getValueAt(infotable.getSelectedRow(), 0) + "' "
							+ " AND CEKI_NOVU = '" + infotable.getValueAt(infotable.getSelectedRow(), 2) + "'");
					command.execute("COMMIT");
					
					command.executeQuery("INSERT INTO SHOPPING "
							+ "VALUES(TO_CHAR(CURRENT_DATE, 'DD-MM-YYYY  HH:MI:SS'), '"
							+ infotable.getValueAt(infotable.getSelectedRow(), 0) + "', "
							+ infotable.getValueAt(infotable.getSelectedRow(), 1) + " , "
							+ Double.parseDouble(enteramount.getText())+ ","
							+ saxtaqiymet + ","
							+ Double.parseDouble(Alinan_Mebleg.getText())+ "," 
							+ Double.parseDouble(qaytarilacaqmebleg.getText()) + "," 
							+ (qalan - Double.parseDouble(enteramount.getText())) + ",'"
							+ BasePage.USER_NAME + "' , '" 
							+ BasePage.USER_PASSWORD + "')");
					connection.close();
				} catch (Exception e1) {e1.printStackTrace();}
			}
		}
		if(e.getActionCommand().equals(refresh.getActionCommand()))
		{
			enterproduct.setText("");
			enteramount.setText("");
			answer.setText("Sum: ");
			Alinan_Mebleg.setText("");
			qaytarilacaqmebleg.setText("");
			kesrmebleg.setText("");
			saxtaqiymet = 0.0;
		}
		if(e.getActionCommand().equals(ana_sehife.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.enter_page.setVisible(true);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		price = Double.parseDouble((infotable.getValueAt(infotable.getSelectedRow(), 1).toString()));	
		mehsul_ad = infotable.getValueAt(infotable.getSelectedRow(), 0).toString();
		ceki_nov = infotable.getValueAt(infotable.getSelectedRow(), 2).toString();
	}
}
