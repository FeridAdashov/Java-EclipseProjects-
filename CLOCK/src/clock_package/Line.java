package clock_package;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Line extends JPanel implements ActionListener{

	int window_en, window_uz;
	int i = 0, 
			j = 220,
			ideq = 0,
			jdeq = 220,
			isaat = 0,
			jsaat = 220,
			uzunluq = 220, 
			vaxt = 0,
			vaxtdeq = 0,
			vaxtsaat = 0;
	double derece = 256.0369999999991, derecedeq = 256.0369999999991, derecesaat = 256.0369999999991;
	Image img;
	Timer time;
	Button bt1, bt2, bt3, bt4, bt5;
	public Line(int uz, int en)
	{
		super();
		this.setBackground(Color.decode("#4FF8C7"));
		window_en = en;
		window_uz = uz;
		
		img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Ferid\\Desktop\\Java\\Program2016\\MyJavaPrograms-2016\\Java_Clock\\clock.png");
		
		this.setLayout(null);
		
		bt1 = new Button("ReStart");
		bt1.setActionCommand("ReStart");
		bt1.addActionListener(this);
		bt1.setBounds(60, 5, 80, 30);
		bt1.setBackground(Color.decode("#4ABDC9"));
		bt1.setForeground(Color.decode("#F10808"));
		bt1.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(bt1);
		
		bt2 = new Button("OnOff");
		bt2.setActionCommand("OnOff");
		bt2.addActionListener(this);
		bt2.setBounds(160, 5, 80, 30);
		bt2.setBackground(Color.decode("#4ABDC9"));
		bt2.setForeground(Color.decode("#F10808"));
		bt2.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(bt2);
		
		bt3 = new Button("SaniyeArtir");
		bt3.setActionCommand("SaniyeArtir");
		bt3.addActionListener(this);
		bt3.setBounds(260, 5, 80, 30);
		bt3.setBackground(Color.decode("#4ABDC9"));
		bt3.setForeground(Color.decode("#F10808"));
		bt3.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(bt3);
		
		bt4 = new Button("DeqiqeArtir");
		bt4.setActionCommand("DeqiqeArtir");
		bt4.addActionListener(this);
		bt4.setBounds(360, 5, 80, 30);
		bt4.setBackground(Color.decode("#4ABDC9"));
		bt4.setForeground(Color.decode("#F10808"));
		bt4.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(bt4);
		
		bt5 = new Button("SaatArtir");
		bt5.setActionCommand("SaatArtir");
		bt5.addActionListener(this);
		bt5.setBounds(460, 5, 80, 30);
		bt5.setBackground(Color.decode("#4ABDC9"));
		bt5.setForeground(Color.decode("#F10808"));
		bt5.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(bt5);
		
		time = new Timer(1000, this);
		time.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(img, 51, 50, this);
		g.setColor(Color.green);
		g.drawLine(window_uz / 2, window_en / 2, window_uz / 2 + isaat, window_en / 2 - jsaat);
		g.setColor(Color.RED);
		g.drawLine(window_uz / 2, window_en / 2, window_uz / 2 + ideq, window_en / 2 - jdeq);
		g.setColor(Color.BLUE);
		g.drawLine(window_uz / 2, window_en / 2, window_uz / 2 + i, window_en / 2 - j);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == bt1.getActionCommand())
		{
			setTime();
		}
		
		else if(e.getActionCommand() == bt2.getActionCommand())
		{
			OnOff();
		}
		
		else if(e.getActionCommand() == bt3.getActionCommand())
		{
			SaniyeArtir();
			i = (int) (uzunluq * Math.cos(-derece));
			j = (int) (uzunluq * Math.sin(-derece));
		}
		
		else if(e.getActionCommand() == bt4.getActionCommand())
		{
			DeqiqeArtir();
			if(vaxtdeq % 12 == 0 && vaxtdeq != 0)
			{
				derecesaat += 0.105;
				vaxtsaat += 0.2;
				isaat = (int) (uzunluq * Math.cos(-derecesaat));
				jsaat = (int) (uzunluq * Math.sin(-derecesaat));
			}
			ideq = (int) (uzunluq * Math.cos(-derecedeq));
			jdeq = (int) (uzunluq * Math.sin(-derecedeq));
		}
		
		else if(e.getActionCommand() == bt5.getActionCommand())
		{
			SaatArtir();
			isaat = (int) (uzunluq * Math.cos(-derecesaat));
			jsaat = (int) (uzunluq * Math.sin(-derecesaat));
		}
		
		else{
			i = (int) (uzunluq * Math.cos(-derece));
			j = (int) (uzunluq * Math.sin(-derece));
			ideq = (int) (uzunluq * Math.cos(-derecedeq));
			jdeq = (int) (uzunluq * Math.sin(-derecedeq));
			isaat = (int) (uzunluq * Math.cos(-derecesaat));
			jsaat = (int) (uzunluq * Math.sin(-derecesaat));
			
			derece += 0.105;
			vaxt++;
			if(vaxt == 60)
			{
				vaxt = 0;
				derece = 256.0369999999991;
				derecedeq += 0.105;
				vaxtdeq++;
			}
			
			if(vaxtdeq == 60)
			{
				vaxtdeq = 0;
				derecedeq = 256.0369999999991;
			}
			
			if(vaxtsaat == 12)
			{
				vaxtsaat = 0;
				derecesaat = 256.0369999999991;
			}
		}
		repaint();
	}
	
	public void setTime()
	{
		i = 0;
		j = 220;
		ideq = 0;
		jdeq = 220;
		isaat = 0;
		jsaat = 220;
		uzunluq = 220; 
		vaxt = 0;
		vaxtdeq = 0;
		vaxtsaat = 0;
		derece = 256.0369999999991;
		derecedeq = 256.0369999999991;
		derecesaat = 256.0369999999991;
	}
	
	public void OnOff()
	{
		if(time.isRunning()) time.stop();
		else time.start();
	}
	
	public void SaniyeArtir()
	{
		vaxt++;
		if(vaxt == 60) derece = 256.0369999999991;
		else derece += 0.105;
	}
	
	public void DeqiqeArtir()
	{
		vaxtdeq++;
		if(vaxtdeq == 60) derecedeq = 256.0369999999991;
		else derecedeq += 0.105;
	}
	
	public void SaatArtir()
	{
		vaxtsaat++;
		if(vaxtsaat == 12) derecesaat = 256.0369999999991;
		else derecesaat += 0.105 * 5;
	}
}
