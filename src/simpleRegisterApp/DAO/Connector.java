package simpleRegisterApp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Singleton connector class for database conectivity
public class Connector {
	
	// Instance variable
	private static Connector connector_instance = null;
	
	// Connection properties
	private static final String USERNAME = "root";
	private static final String PASSWORD = "T3Dh2K1m5c";
	private static final String CONN_STRING = "jdbc:mysql://localhost/students?useSSL=false";
	
	// Connection object
	private Connection connection = null;
	
	// Private constructor
	private Connector(){}
	
	// Get singleton instance
	public static Connector getInstance(){
		
		if(connector_instance == null){
			connector_instance = new Connector();
		}
		
		return connector_instance;
	}
	
	// Open connection
	private boolean openConnection(){
		try {
			connection = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
			return true;
		}
		catch (SQLException e){
			System.err.println(e);
			return false;
		}
	}
	
	// Get connection
	public Connection getConnection() {
		if(connection == null){
			if(openConnection()){
				System.out.println("Konekcija uspostavljena!");
				return connection;
			}
			else{
				return null;
			}
		}
		return connection;
	}
	
	// Close connection
	public void close() {
		try {
			connection.close();
			connection = null;
			System.out.println("Konekcija zatvorena");
		}
		catch (Exception e){
			System.err.println(e);
		}
		
	}
}
