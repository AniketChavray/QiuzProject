package com.velocity.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {

	
	public  static void displayResults(String pass) {
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "Select Grade, Result From velocity_student_details where pasword = ?";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, pass);
			
			ResultSet rs = pr.executeQuery();
			
			String grade = rs.getString("Grade");
			String Score = rs.getString("Result");
				
			if(grade.equals(null)) {
				
				System.out.println("You have not taken quiz yet, login in again and take quiz first");
				
				Login login = new Login();
				login.loginUser();
				
			}else if (grade.equals("F")){
				
				System.out.println("Unfortuantely you are failed as you have score below 40");
				System.out.println("All the best for next time");
			}else {
				
				System.out.println("Your grade is: " + grade);
				System.out.println("Your marks out of hundered are: " + Score);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
