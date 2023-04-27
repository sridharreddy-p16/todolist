package java_proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Users {
	
	static String uname;
	static String password;
	static Scanner sc = new Scanner(System.in);
	static Connection con = Main.con;
	static PreparedStatement pstmt;
	static ResultSet res;
	public Users(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	static void userRegister() {
		try {
			System.out.println("Enter username:");
			uname=sc.next();
			System.out.println("Enter password:");
			password=sc.next();
			String sql = "insert into users values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, password);
			int x = pstmt.executeUpdate();
			if(x>0) {
				System.out.println("User registerd!");
			}
			else {
				System.out.println("User not registerd please try again");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	static void userLogin() {
		try {
			System.out.println("Enter username:");
			uname=sc.next();
			System.out.println("Enter password:");
			password=sc.next();
			String sql = "select * from users where uname=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if(res.next()==true) {
				System.out.println("User logged in successfully!\n"
						+"Welcome to TodoList application"+res.getString(1));
				ToDo_Tasks.tasksList(uname);
			}
			else {
				System.out.println("user login failed. try again");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
