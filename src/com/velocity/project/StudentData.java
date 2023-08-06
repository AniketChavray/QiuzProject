package com.velocity.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public  class StudentData  implements Student{

	@Override
	public  void insertStudentData(String fname, String lname, String studentMail, String city, long mobNum, int pin) {
		
		Connection con = null;
		PreparedStatement pr = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			pr = con.prepareStatement("INSERT  INTO Velocity_Student_Details(First_Name,Last_Name, Student_Mail_Id, City,Mobile_Number,Pasword) values (?,?,?,?,?,?)" );
			pr.setString(1,fname );
			pr.setString(2, lname);
			pr.setString(3,studentMail );
			pr.setString(4,city );
			pr.setLong(5,mobNum);
			pr.setInt(6,pin);
			
			
			
			int i = pr.executeUpdate();
			System.out.println( i + " records are inserted successfully" );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			
			try {
				con.close();
				pr.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
	
}

	
	public void inputDetails() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name");
		String fname = sc.next();
		System.out.println("Enter your last name");
		String lname = sc.next();
		System.out.println("Enter your mail id");
		String studentMail = sc.next();
		System.out.println("Enter your city");
		String city = sc.next();
		System.out.println("Enter your mobile number");
		long mobNum = sc.nextLong();
		System.out.println("Type four digit password");
		int pin = sc.nextInt();
		
		this.insertStudentData(fname,lname, studentMail, city, mobNum, pin);
		
		
	}
	



}
