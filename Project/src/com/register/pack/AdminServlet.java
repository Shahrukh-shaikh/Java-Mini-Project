package com.register.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminlog")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		 String psw = request.getParameter("psw");
		 
		 
		 RegistrationPage rp = new RegistrationPage();
			
		 rp.setUsername(username);
		 rp.setPsw(psw);
		 
		 RegistrationService rs = new RegistrationService();
		 boolean user=RegistrationService.checkAdminlogin(username, psw);
		 if (user) {
			 System.out.println("Login successfully");
			 request.getRequestDispatcher("servlet.html").forward(request, response);
		 }
		 request.getRequestDispatcher("AdminLogin.html").forward(request, response);

		 System.out.println("Error in login");
		 

			
		}
		 

		//doGet(request, response);
	}


