import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDao {

	// Connect to DB
	Connection connection = Connector.getInstance().getConnection();
	
	// Register new user
	public void registerNewUser() throws SQLException {
		
		// Create SQL query 
		String query = "INSERT INTO users(username,password) VALUES(?,?)";
		
		// Scanner
		Scanner unos = new Scanner(System.in);
		
		// Enter new username
		System.out.println("Enter desired username:");
		String username = unos.nextLine();
		
		// Enter new password
		System.out.println("Enter new password");
		String password = unos.nextLine();
		
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, password);
		
		statement.executeUpdate();
		
		System.out.println("Student added to database");
		
	}
}
