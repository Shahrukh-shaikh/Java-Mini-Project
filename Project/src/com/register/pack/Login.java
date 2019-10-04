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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 mdjavhash md = new mdjavhash();
		 String psw = request.getParameter("psw");
		 
	
		
		
		 RegistrationPage rp = new RegistrationPage();
		
		 rp.setUsername(username);
		
		 rp.setPsw(psw);
		
		 
		 //rp.setFname(firstName);
		// rp.setLname(lastName);
		 
		 //RegistrationService rs = new RegistrationService();
		 boolean userRegistered = false;
		try {
			userRegistered = RegistrationService.checklogin(username, md.getHashPass(psw));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (userRegistered) 
		 {
			 System.out.println("Login successfully");
			 request.setAttribute("object",rp);
			 request.getRequestDispatcher("log.jsp").forward(request, response);
			 }
	 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("invalid.html").forward(request, response);
		System.out.println("error in login");
		System.out.println(psw);
	}
	}
}
