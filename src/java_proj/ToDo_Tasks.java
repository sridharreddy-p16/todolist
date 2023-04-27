package java_proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ToDo_Tasks {
	static String uname;
	static Connection con = Main.con;
	static void tasksList(String user) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select an option\n"
				+"1.add tasks\n"
				+"2.view tasks\n"
				+"3.update tasks\n"
				+"4.remove tasks\n"
				+"5.exit");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:{
			addTask();
			break;
		}
		case 2:{
			viewTask();
			break;
		}
		case 3:{
			updateTask();
			break;
		}
		case 4:{
			removeTask();
			break;
		}
		case 5:{
			System.exit(0);
			}
		default :
			System.out.println("Enter valid choice:");
		}
	}
	static void addTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the task name:");
		String task_name = sc.next();
		System.out.println("enter the task description:");
		String task_desc = sc.next();
		String sql = "insert into todolist (task_name,description,user_name) values (?,?,?)";
		try {
		PreparedStatement psmt =con.prepareStatement(sql);
		psmt.setString(1, task_name);
		psmt.setString(2, task_desc);
		psmt.setString(3, uname);
		int x= psmt.executeUpdate();
		if(x>0) {
			System.out.println("Task added ");
			ToDo_Tasks.tasksList(uname);
		}
		else {
			System.out.println("Task not added ");
			ToDo_Tasks.tasksList(uname);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	static void viewTask() {
		String sql = "select * from todolist";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet res = psmt.executeQuery();
			if(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"
						+res.getString(3)+"\t"+res.getString(4)+"\t"+res.getString(5));
			}
			else
				System.out.println("No tasks found!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	static void updateTask() {
		
	}
	static void removeTask() {
		
	}

}
