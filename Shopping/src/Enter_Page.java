import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Enter_Page  extends JPanel implements ActionListener{

	JLabel basliq, user_name, user_password, admin_name, admin_password;
	JButton user, admin;
	JTextField username, adminname;
	JPasswordField userpassword, adminpassword;
	
	public Enter_Page() {
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#62BBA1"));
		
		basliq = new JLabel("SHOPPING");
		basliq.setBounds(250, 0, 285, 50);
		basliq.setForeground(Color.decode("#37197D"));
		basliq.setFont(new Font("BroadWay", Font.ITALIC, 50));
		this.add(basliq);
		
		user_name = new JLabel("USER_NAME");
		user_name.setBounds(30, 150, 200, 40);
		user_name.setForeground(Color.red);
		user_name.setFont(new Font("Courier", Font.BOLD, 17));
		this.add(user_name);
		
		username = new JTextField();
		username.setBounds(170, 155, 160, 25);
		username.setForeground(Color.BLUE);
		username.setFont(new Font("Courier", Font.BOLD, 15));
		username.setBackground(Color.decode("#ABD4C8"));
		this.add(username);
		
		user_password = new JLabel("USER_PASSWORD");
		user_password.setBounds(30, 200, 200, 40);
		user_password.setForeground(Color.red);
		user_password.setFont(new Font("Courier", Font.BOLD, 17));
		this.add(user_password);
		
		userpassword = new JPasswordField();
		userpassword.setBounds(170, 205, 160, 25);
		userpassword.setForeground(Color.BLUE);
		userpassword.setFont(new Font("Courier", Font.BOLD, 15));
		userpassword.setBackground(Color.decode("#ABD4C8"));
		this.add(userpassword);
		
		admin_name = new JLabel("ADMIN_NAME");
		admin_name.setBounds(440, 150, 200, 40);
		admin_name.setForeground(Color.red);
		admin_name.setFont(new Font("Courier", Font.BOLD, 17));
		this.add(admin_name);
		
		adminname = new JTextField();
		adminname.setBounds(585, 155, 160, 25);
		adminname.setForeground(Color.BLUE);
		adminname.setFont(new Font("Courier", Font.BOLD, 15));
		adminname.setBackground(Color.decode("#ABD4C8"));
		this.add(adminname);
		
		admin_password = new JLabel("ADMIN_PASSWORD");
		admin_password.setBounds(440, 200, 200, 40);
		admin_password.setForeground(Color.red);
		admin_password.setFont(new Font("Courier", Font.BOLD, 17));
		this.add(admin_password);
		
		adminpassword = new JPasswordField();
		adminpassword.setBounds(585, 205, 160, 25);
		adminpassword.setForeground(Color.BLUE);
		adminpassword.setFont(new Font("Courier", Font.BOLD, 15));
		adminpassword.setBackground(Color.decode("#ABD4C8"));
		this.add(adminpassword);
		
		user = new JButton("ENTER_AS_USER");
		user.setBounds(30, 300, 300, 50);
		user.setForeground(Color.BLUE);
		user.setBackground(Color.decode("#7ADEA1"));
		user.setFont(new Font("", Font.BOLD, 14));
		user.addActionListener(this);
		this.add(user);
		
		admin = new JButton("ENTER_AS_ADMINSTRATOR");
		admin.setBounds(440, 300, 305, 50);
		admin.setForeground(Color.BLUE);
		admin.setBackground(Color.decode("#7ADEA1"));
		admin.setFont(new Font("", Font.BOLD, 14));
		admin.addActionListener(this);
		this.add(admin);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(user.getActionCommand()))
		{
			if(username.getText().equals(BasePage.USER_NAME) && userpassword.getText().equals(BasePage.USER_PASSWORD))
			{
				this.setEnabled(false);
				this.setVisible(false);
				BasePage.userPage = new Enter_As_User();
				BasePage.mainWindow.add(BasePage.userPage);
				username.setText("");
				userpassword.setText("");
			}
		}
		
		if(e.getActionCommand().equals(admin.getActionCommand()))
		{
			if(adminname.getText().equals(BasePage.ADMIN_NAME) && adminpassword.getText().equals(BasePage.ADMIN_PASSWORD))
			{
				this.setEnabled(false);
				this.setVisible(false);
				BasePage.Admin = new Enter_As_Adminstrator();
				BasePage.mainWindow.add(BasePage.Admin);
				adminname.setText("");
				adminpassword.setText("");
			}
		}
		
	}

}
