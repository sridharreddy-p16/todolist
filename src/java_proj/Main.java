package java_proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	static Connection con;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Driver loaded");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop","root","root");
		System.out.println("Select the option\n"
				+"1.Register as new user\n"
				+"2.Login");
		System.out.println("Enter the option");
		int choice = sc.nextInt();
		if(choice==1) {
			Users.userRegister();
		}
		else if(choice==2) {
			Users.userLogin();
		}
		else {
			System.out.println("Enter valid option");
		}
		}
		catch(Exception se) {
			se.printStackTrace();
		}
	}

}
