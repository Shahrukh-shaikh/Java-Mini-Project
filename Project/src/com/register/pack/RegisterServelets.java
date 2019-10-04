package com.register.pack;

import java.io.IOException;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Encryptionmd5.mdjavhash;
import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class RegisterServelets
 */
@WebServlet("/rs.do")
public class RegisterServelets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServelets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
	
		 String firstName = request.getParameter("firstname"); 
		 String lastName = request.getParameter("lastname");
		 String username=firstName.charAt(0)+lastName;
		 mdjavhash md = new mdjavhash();
 		 String password = request.getParameter("password");
 		
	
		 
		 String email = request.getParameter("email");
		 
		 
		 PrintWriter out = response.getWriter();
		 //user enter data is submitted to register page
		 RegistrationPage rp = new RegistrationPage();
		 rp.setFname(firstName);
		 rp.setLname(lastName);
		 rp.setUsername(username);
		 try {
			rp.setPsw(md.getHashPass(password));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 rp.setEmail(email);
		 
		 
		 
		// out.println(firstName);
		 RegistrationService rs = new RegistrationService();
		 boolean userRegistered= rs.addUser(rp);
		
		 
		
		 if(userRegistered)   //On success, you can display a message to user on Home page
		 {
			 request.setAttribute("object",rp);

		 request.getRequestDispatcher("logsucc.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			 System.out.println("Error in database");
		// request.setAttribute("errMessage", userRegistered);
		// request.getRequestDispatcher("/l").forward(request, response);
		 }
		 
		 
		//doGet(request, response);
	}

}
