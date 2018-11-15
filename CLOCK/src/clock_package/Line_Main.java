package clock_package;
import javax.swing.JFrame;

public class Line_Main{

	public static void main(String[] args) {

		JFrame window = new JFrame("LINE");
		window.setBounds(600, 100, 600, 600);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new Line(window.getWidth(), window.getHeight()));
	}

}
