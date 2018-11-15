import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Enter_As_Adminstrator extends JPanel implements ActionListener{

	JLabel bir;
	JButton Profil, Data, Shopping;
	JTextArea textarea;
	
	public Enter_As_Adminstrator() {
		super();
		this.setLayout(null);
		this.setBackground(Color.decode("#83BEE3"));
		
		bir = new JLabel("ADMINSTRATOR");
		bir.setBounds(280, 0, 285, 50);
		bir.setForeground(Color.decode("#123C7D"));
		bir.setFont(new Font("BroadWay", Font.ITALIC, 25));
		this.add(bir);
		
		bir = new JLabel("1.");
		bir.setBounds(20, 95, 30, 20);
		bir.setForeground(Color.decode("#123C7D"));
		bir.setFont(new Font("", Font.BOLD, 25));
		this.add(bir);
		
		Profil = new JButton("PROFİL");
		Profil.setBounds(50, 80, 150, 50);
		Profil.setForeground(Color.BLUE);
		Profil.setBackground(Color.decode("#98DAB6"));
		Profil.setFont(new Font("", Font.BOLD, 14));
		Profil.addActionListener(this);
		this.add(Profil);
		
		bir = new JLabel("2.");
		bir.setBounds(20, 165, 30, 20);
		bir.setForeground(Color.decode("#123C7D"));
		bir.setFont(new Font("", Font.BOLD, 25));
		this.add(bir);
		
		Data = new JButton("DATA");
		Data.setBounds(50, 150, 150, 50);
		Data.setForeground(Color.BLUE);
		Data.setBackground(Color.decode("#98DAB6"));
		Data.setFont(new Font("", Font.BOLD, 14));
		Data.addActionListener(this);
		this.add(Data);
		
		bir = new JLabel("3.");
		bir.setBounds(20, 235, 30, 20);
		bir.setForeground(Color.decode("#123C7D"));
		bir.setFont(new Font("", Font.BOLD, 25));
		this.add(bir);
		
		Shopping = new JButton("SHOPPING");
		Shopping.setBounds(50, 220, 150, 50);
		Shopping.setForeground(Color.BLUE);
		Shopping.setBackground(Color.decode("#98DAB6"));
		Shopping.setFont(new Font("", Font.BOLD, 14));
		Shopping.addActionListener(this);
		this.add(Shopping);
		
		textarea = new JTextArea();
		textarea.setBounds(350, 75, 400, 200);
		textarea.setLineWrap(true);
		textarea.setEditable(false);
		textarea.setBackground(Color.decode("#83BEE3"));
		textarea.setForeground(Color.decode("#768085"));
		textarea.setFont(new Font("", Font.BOLD, 18));
		textarea.setText("1.You can change User profil or Admin profil\n\n\n"
				+ "2.You can change, get, delete or insert DATA\n\n\n"
				+ "3.You can see all shopping");
		this.add(textarea);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(Profil.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.Profil = new Change_Profil();
			BasePage.mainWindow.add(BasePage.Profil);
			BasePage.Profil.setVisible(true);
		}
		if(e.getActionCommand().equals(Data.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.Data = new Data_Changes();
			BasePage.mainWindow.add(BasePage.Data);
			BasePage.Data.setVisible(true);
		}
		if(e.getActionCommand().equals(Shopping.getActionCommand()))
		{
			this.setVisible(false);
			BasePage.shopping = new Shopping();
			BasePage.mainWindow.setSize(1100, 500);
			BasePage.mainWindow.add(BasePage.shopping);
			BasePage.shopping.setVisible(true);
		}
	}

}
