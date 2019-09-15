


public class User {
	
	// Data fields
	private String username;
	private String password;
	private String logInMessage = "Hi " + username;
	
	// Constructors
	User(){}

	User(String username, String password, String logInMessage) {
		super();
		this.username = username;
		this.password = password;
		this.logInMessage = logInMessage;
	}

	public String getUsername() {
		return username;
	}

	
	// Get & Set
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogInMessage() {
		return logInMessage;
	}

	
	// To String
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", logInMessage=" + logInMessage + "]";
	}
	
	
	

}
