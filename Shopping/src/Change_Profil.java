import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Change_Profil extends JPanel implements ActionListener{

	JLabel basliq, change_user_profil, change_admin_profil, new_user_name, new_user_password, new_admin_name, new_admin_password;
	JTextField New_User_Name, New_User_Password, New_Admin_Name, New_Admin_Password;
	JButton Save_User_Profil_Data, Save_Admin_Profil_Data, Adminstrator_Page, Main_Page;
	
	public Change_Profil() {
		
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#7D8574"));
		
		basliq = new JLabel("PROFIL_SETTINGS");
		basliq.setBounds(280, 0, 285, 50);
		basliq.setForeground(Color.decode("#123C7D"));
		basliq.setFont(new Font("BroadWay", Font.ITALIC, 25));
		this.add(basliq);
		
		change_user_profil = new JLabel("Change_User_Profil");
		change_user_profil.setBounds(20, 50, 285, 50);
		change_user_profil.setForeground(Color.decode("#C1DCCC"));
		change_user_profil.setFont(new Font("BroadWay", 0, 20));
		this.add(change_user_profil);
		
		change_admin_profil = new JLabel("Change_Admin_Profil");
		change_admin_profil.setBounds(450, 50, 285, 50);
		change_admin_profil.setForeground(Color.decode("#C1DCCC"));
		change_admin_profil.setFont(new Font("BroadWay", 0, 20));
		this.add(change_admin_profil);
		
		new_user_name = new JLabel("New_User_Name");
		new_user_name.setBounds(20, 150, 285, 50);
		new_user_name.setForeground(Color.decode("#C1DCCC"));
		new_user_name.setFont(new Font("BroadWay", 0, 15));
		this.add(new_user_name);
		
		new_user_password = new JLabel("New_User_Password");
		new_user_password.setBounds(20, 200, 285, 50);
		new_user_password.setForeground(Color.decode("#C1DCCC"));
		new_user_password.setFont(new Font("BroadWay", 0, 15));
		this.add(new_user_password);
		
		new_admin_name = new JLabel("New_Admin_Name");
		new_admin_name.setBounds(450, 150, 285, 50);
		new_admin_name.setForeground(Color.decode("#C1DCCC"));
		new_admin_name.setFont(new Font("BroadWay", 0, 15));
		this.add(new_admin_name);
		
		new_admin_password = new JLabel("New_User_Password");
		new_admin_password.setBounds(450, 200, 285, 50);
		new_admin_password.setForeground(Color.decode("#C1DCCC"));
		new_admin_password.setFont(new Font("BroadWay", 0, 15));
		this.add(new_admin_password);
		
		New_User_Name = new JTextField();
		New_User_Name.setBounds(200, 160, 160, 25);
		New_User_Name.setBackground(Color.decode("#ADC1C4"));
		New_User_Name.setForeground(Color.BLUE);
		New_User_Name.setFont(new Font("", Font.BOLD, 14));
		this.add(New_User_Name);
		
		New_User_Password = new JPasswordField();
		New_User_Password.setBounds(200, 210, 160, 25);
		New_User_Password.setBackground(Color.decode("#ADC1C4"));
		New_User_Password.setForeground(Color.BLUE);
		New_User_Password.setFont(new Font("", Font.BOLD, 14));
		this.add(New_User_Password);
		
		New_Admin_Name = new JTextField();
		New_Admin_Name.setBounds(625, 160, 160, 25);
		New_Admin_Name.setBackground(Color.decode("#ADC1C4"));
		New_Admin_Name.setForeground(Color.BLUE);
		New_Admin_Name.setFont(new Font("", Font.BOLD, 14));
		this.add(New_Admin_Name);
		
		New_Admin_Password = new JPasswordField();
		New_Admin_Password.setBounds(625, 210, 160, 25);
		New_Admin_Password.setBackground(Color.decode("#ADC1C4"));
		New_Admin_Password.setForeground(Color.BLUE);
		New_Admin_Password.setFont(new Font("", Font.BOLD, 14));
		this.add(New_Admin_Password);
		
		Save_User_Profil_Data = new JButton("Save_User_Profil_Data");
		Save_User_Profil_Data.setBounds(20, 300, 210, 35);
		Save_User_Profil_Data.setForeground(Color.BLUE);
		Save_User_Profil_Data.setBackground(Color.decode("#A0ECF5"));
		Save_User_Profil_Data.setFont(new Font("", Font.BOLD, 14));
		Save_User_Profil_Data.addActionListener(this);
		this.add(Save_User_Profil_Data);

		Save_Admin_Profil_Data = new JButton("Save_Admin_Profil_Data");
		Save_Admin_Profil_Data.setBounds(450, 300, 210, 35);
		Save_Admin_Profil_Data.setForeground(Color.BLUE);
		Save_Admin_Profil_Data.setBackground(Color.decode("#A0ECF5"));
		Save_Admin_Profil_Data.setFont(new Font("", Font.BOLD, 14));
		Save_Admin_Profil_Data.addActionListener(this);
		this.add(Save_Admin_Profil_Data);
		
		Adminstrator_Page = new JButton("<-- Adminstrator_Page");
		Adminstrator_Page.setBounds(20, 380, 210, 35);
		Adminstrator_Page.setForeground(Color.decode("#884792"));
		Adminstrator_Page.setBackground(Color.decode("#70C680"));
		Adminstrator_Page.setFont(new Font("", Font.BOLD, 14));
		Adminstrator_Page.addActionListener(this);
		this.add(Adminstrator_Page);
		
		Main_Page = new JButton("<-- Main_Page");
		Main_Page.setBounds(20, 430, 210, 35);
		Main_Page.setForeground(Color.decode("#884792"));
		Main_Page.setBackground(Color.decode("#70C680"));
		Main_Page.setFont(new Font("", Font.BOLD, 14));
		Main_Page.addActionListener(this);
		this.add(Main_Page);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Connection connection = null;
		java.sql.Statement command = null;
		
		
		if(e.getActionCommand().equals(Save_User_Profil_Data.getActionCommand()))
		{
			try {
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				command.executeQuery("UPDATE SHOPPING_PROFILES_DATA SET USER_NAME = '" + New_User_Name.getText()
						+ "' , USER_PASSWORD = '" + New_User_Password.getText() + "'");
				command.execute("commit");
				connection.close();
				BasePage.USER_NAME = New_User_Name.getText();
				BasePage.USER_PASSWORD = New_User_Password.getText();
			} catch (Exception e1) {
				System.out.println("ERROR HAPPENED IN COMMAND " + e1.toString());
			}
		}
		if(e.getActionCommand().equals(Save_Admin_Profil_Data.getActionCommand()))
		{
			try {
				Db_Properties properties = new Db_Properties();
				Class.forName(properties.getDriver());
				connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
				command = connection.createStatement();
				command.executeQuery("UPDATE SHOPPING_PROFILES_DATA SET ADMIN_NAME = '" + New_Admin_Name.getText()
						+ "' , ADMIN_PASSWORD = '" + New_Admin_Password.getText() + "'");
				command.execute("commit");
				connection.close();
				BasePage.ADMIN_NAME = New_Admin_Name.getText();
				BasePage.ADMIN_PASSWORD = New_Admin_Password.getText();
			} catch (Exception e1) {
				System.out.println("ERROR HAPPENED IN COMMAND " + e1.toString());
			}
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

}
