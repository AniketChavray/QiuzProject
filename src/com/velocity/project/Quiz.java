package com.velocity.project;

import java.util.Scanner;

public class Quiz {
	
	
	public void welcome () {
		StudentData studentdata = new StudentData();
		boolean condition = false;
		System.out.println("\t\t\t\t\t\t Welcome to the Quiz Application!!");
		Login login = new Login();
		
		do {
			
			    System.out.println("Select your option from the following: \n 1. New Student Registration \n 2. Student Login/Admin Login \n 3. Exit \n\n Enter your option\n");
			     
			    Scanner sc = new  Scanner(System.in);
			    int option = sc.nextInt();
			    
			    switch(option) {
			    
			    case 1:
			    	    studentdata.inputDetails();
			    	    break;
			    case 2:
			    	   login.loginUser();
			    	
			    case 3:
			    	
			    	
			    	condition = true;
			    
			    } 
			
			
			
		}while(condition =! true);
		
		
		
	}
	
	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		quiz.welcome();
	}

}
