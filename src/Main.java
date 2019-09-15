import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException{
		
		int input = 0;
		Scanner unos = new Scanner(System.in);
		UserDao userDao = new UserDao();
		
	do{
			
		System.out.println("1. REGISTER");
		System.out.println("2. LOG IN");
		System.out.println("3. EXIT");
		
		input = unos.nextInt();
		
		if(input == 1){
			System.out.println("Register");
			userDao.registerNewUser();
		}
		if(input == 2){
			System.out.println("Log in");
		}
	}
	while(input != 3);
	
	System.out.println("Bye noob!");
	}
}
