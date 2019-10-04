package MainPackage;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Encryptionmd5.mdjavhash;
import ProjectDao.RegistrationDao;
import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

public class MainReg {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("ENTER YOUR CHOICE");
			int ch=sc.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("1. Insert values");
			
			
			RegistrationService rs=new RegistrationService();
			
			System.out.println("Enter Userid: ");
			int userid=sc.nextInt();
			System.out.println("Enter First Name: ");
			String fname=sc.next();
			System.out.println("Enter Last Name: ");
			String lname=sc.next();
			System.out.println("Enter your Email id: ");
			String email=sc.next();
			System.out.println("Enter username");
			String username= sc.next();
			System.out.println("Enter Password");
			String psw=sc.next();
			
			RegistrationPage rp = new RegistrationPage(userid, fname, lname, email, username, psw);
			boolean result = rs.addUser(rp);
			if(result)
				System.out.println("User Registered Successfully");
			else
				System.out.println("User not added");
			break;
			case 2:
				
				System.out.println("Enter username");
				String user=sc.next();
				System.out.println("Enter password");
				String pass=sc.next();
				
				Boolean acdBoolean = RegistrationService.checklogin(user,pass);
				if (acdBoolean) {
					System.out.println("Successfull");
				}else {
					System.out.println("Invalid Credentials");
				}
				break;
				
			case 3:
				System.out.println("Admin Login");
				
				System.out.println("Enter username");
				String user1=sc.next();
				System.out.println("Enter password");
				String pass1=sc.next();
				
				Boolean acdBoolean1 = RegistrationService.checkAdminlogin(user1,pass1);
				if (acdBoolean1) {
					System.out.println("Successfull");
				}else {
					System.out.println("Invalid Credentials beta");
					
				}
				break;
			case 4:
				System.out.println("update user");
				System.out.println("username");
				String user2=sc.next();
				System.out.println("userid");
				int ud=sc.nextInt();
				System.out.println("fname");
				String fname1=sc.next();
				System.out.println("lname");
				String lname1=sc.next();
				System.out.println("email");
				String email12=sc.next();
				System.out.println("password");
				String pass12=sc.next();
		        RegistrationService rs12 = new RegistrationService();
		        RegistrationPage update = new RegistrationPage(ud,fname1, lname1, email12,user2, pass12);

		       boolean result12 = rs12.updateuser(update);
		       if (result12) {
				System.out.println("Successfully updated");
			}
		        System.out.println("error in update");	
		        break;
	

			
				
	}
			
			
	}

		
	 
}
