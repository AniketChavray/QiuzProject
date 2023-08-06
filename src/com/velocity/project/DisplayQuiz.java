package com.velocity.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayQuiz {

	public static int
	displayquestions() {
		Scanner sc = new Scanner (System.in);
		int Count = 0;
		try {
			Connection con =  DBConnection.getConnection();
			String query = "Select * java_questions";
			PreparedStatement pr = con.prepareStatement(query);
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("Question:" + rs.getString(2));
				System.out.println("Option" + rs.getString(3));
				System.out.println("Option" + rs.getString(4));
				System.out.println("Option" + rs.getString(5));
				System.out.println("Option" + rs.getString(6));
				String correctAns = rs.getString(7);
				
				System.out.println("Enter your option");
				String choice = sc.next();
				
				if(choice == correctAns) {
					
					Count++;
				}
				
				
			}
			
			
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
			try {
				DBConnection.getConnection().close();
				DBConnection.getConnection().prepareStatement("Select * java_questions Order By Rand() limit 10").close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Count;
		
		
	}
	
}
