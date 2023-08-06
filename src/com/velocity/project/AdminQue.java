package com.velocity.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public  class AdminQue implements Admin   {

@Override
	public void setQuestions(String Que, String opt1, String opt2, String opt3, String opt4,String copt) {
		
		
		Connection conn = null ;
		PreparedStatement prs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			prs = conn.prepareStatement("Insert Into java_questions(Questions, Option1,Option2,Option3, Option4, Correct_Option)values(?,?,?,?,?,?)");
			prs.setString(1, Que);
			
			prs.setString(2,opt1 );
			prs.setString(3,opt2);
			prs.setString(4, opt3);
			prs.setString(5, opt4);
			prs.setString(6, copt);
			
			int i = prs.executeUpdate();
			System.out.println("Question inserted successfully");
			
			
			
			
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}finally {
			
			try {
				conn.close();
				prs.close();
			} catch (SQLException e) {
				System.out.println("error in catch");
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	public void inputQue() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Add your questions and their option and the correct alternative separately");
      		
		
		System.out.println("Type your question");
		String Que = sc.nextLine();
		
		System.out.println("Type first option");
		String opt1 =  sc.nextLine();
		
		System.out.println( "Type second option");
		String opt2 = sc.nextLine();
		  
		System.out.println( "Type third option");
		String opt3 = sc.nextLine();
		 
		System.out.println(  "Type fourth option");
		String opt4 = sc.nextLine();
		 
		System.out.println("Type correct option");
		String copt = sc.nextLine();
		
		sc.close();
		
		this.setQuestions(Que, opt1, opt2,opt3,opt4,copt);
		
		
		}
		



	
	public static void main(String[] args) {
		
		AdminQue aq = new AdminQue();
		aq.inputQue();
		
	}
	
}
