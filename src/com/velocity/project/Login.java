package com.velocity.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	
	
	public void loginUser () {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Plese enter your registered mail id");
		String mailID = sc.nextLine();
		
		System.out.println("Please enter your password");
		String pass =  sc.nextLine();
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "Select password from Table where username =?";
			
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, pass);
			
			
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				
				String storedPass = rs.getString("Password");
				if (pass.equals("Admin")) {
					
					System.out.println(" Admin Login Successfull!!");
					
					
				}else if(pass.equals(storedPass)){
					 boolean value = true;
					System.out.println("Student Login Successfull!!");
					do { System.out.println("1. Start Quiz");
					 System.out.println("\n 2.Display your Results");
					  System.out.println("\n Enter your option");
					  int yourchoice = sc.nextInt();
					
					  if(yourchoice==1) {
						  System.out.println("There are total 10 questions each carrying 10 marks");
						  int Score = DisplayQuiz.displayquestions();
						  Score = Score*10;
						  PreparedStatement pr1 = con.prepareStatement("Update velocity_student_details set Result = ? where pasword = ?");
						  pr.setInt(1,Score);
						  pr.setString(2, pass);
						  
						  int i = pr.executeUpdate();
						  
//						  call to grade calculate method , generate class for that then return grade and then update here with query
						  						  
						  String grade = GradeCalculate.grade(Score);
						  
						  PreparedStatement pr2 = con.prepareStatement("Update velocity_student_detail set Grade = ? where pasword = ?");
						  pr.setString(1, grade);
						  pr.setString(2, pass);
						  
						  int j = pr.executeUpdate();
						  
						  
						  
						  
					  }else if(yourchoice == 2) {
						  
						  Result.displayResults(pass);
					  }else {
						  value = false;
						  System.out.println("Choose correct option please");
						  
					  }
					}while (value = false);
				}
			}
			   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			
			try {
				DBConnection.getConnection().close();
				DBConnection.getConnection().prepareStatement("Update velocity_student_details set Result = ? where pasword = ?").close();
				DBConnection.getConnection().prepareStatement("Update velocity_student_detail set Grade = ? where pasword = ?").close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
