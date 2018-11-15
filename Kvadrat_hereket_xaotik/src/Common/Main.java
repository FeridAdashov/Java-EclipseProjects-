package Common;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	public static ArrayList<Kvadrat> kvlar = new ArrayList<Kvadrat>();
	
	
	
	public static void main(String s[])
	{
		JFrame pencere = new JFrame("MyProject");
		Acting act1 = new Acting();
		act1.setBackground(Color.CYAN);
		pencere.add(act1);
		pencere.setSize(500, 300);
		pencere.setVisible(true);
		pencere.setLocation(200, 100);
		pencere.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}