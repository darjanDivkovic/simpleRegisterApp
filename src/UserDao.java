import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public User logIn() throws SQLException {
		User user = null;
		
		Scanner unos = new Scanner(System.in);
		
		System.out.println("Enter username:");
		String username = unos.next();
		
		System.out.println("Enter password:");
		String password = unos.next();
		
		// Find username, exists ?
		if(!usernameExists(username))
			return null;
		// Password check ? == ?
		if(!passwordCheck(username, password)){
			return null;
		}
		
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	}
	
	private boolean usernameExists(String username) throws SQLException{
		
		// Query
		String query = "select * from users where username=?";
		
		// Statement
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		
		// Result set
		ResultSet rs = statement.executeQuery(query);
		
		// Set the position
		rs.next();
		
		// Retrieve username
		String retrievedUsername = rs.getString(1);
		
		// Check 
		if(username == retrievedUsername){
			return true;
			
		}
		System.out.println("Username doesn't exist!");
		return false;
		
	}
	
	private boolean passwordCheck(String username, String password) throws SQLException{
		
		String query = "Select * from users where username="+username;
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		rs.next();
		
		String retrievedPassword = rs.getString(2);
		
		if(password == retrievedPassword)
			return true;
		else{
			System.out.println("Password incorrect");
			return false;
		}

		
	}
}
