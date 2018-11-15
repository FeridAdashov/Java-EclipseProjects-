import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BasePage extends JFrame{

	protected static BasePage mainWindow;
	protected static Enter_Page enter_page;
	protected static Enter_As_User userPage;
	protected static Enter_As_Adminstrator Admin;
	protected static Change_Profil Profil;
	protected static Data_Changes Data;
	protected static Shopping shopping;
	protected static String USER_NAME;
	protected static String USER_PASSWORD;
	protected static String ADMIN_NAME;
	protected static String ADMIN_PASSWORD;
	
	
	public BasePage() {
		super();
		this.setBounds(200, 100, 800, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		try {
			Db_Properties properties = new Db_Properties();
			Class.forName(properties.getDriver());
			Connection connection = DriverManager.getConnection(properties.getURL(), properties.getUsername(), properties.getPassword());
			Statement command = connection.createStatement();
			ResultSet result = command.executeQuery("SELECT * FROM SHOPPING_PROFILES_DATA");
			result.next();
			USER_NAME = result.getString("USER_NAME");
			USER_PASSWORD = result.getString("USER_PASSWORD");
			ADMIN_NAME = result.getString("ADMIN_NAME");
			ADMIN_PASSWORD = result.getString("ADMIN_PASSWORD");
			connection.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("ERROR HAPPENED IN SQL " + e1.toString());
		}
	}

	public static void main(String[] args) {

		mainWindow = new BasePage();
		enter_page = new Enter_Page();
		mainWindow.add(enter_page);
	}
}