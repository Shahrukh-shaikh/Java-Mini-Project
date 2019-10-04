package com.register.pack;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Encryptionmd5.mdjavhash;
import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class updateuser
 */
@WebServlet("/updateinfo")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuser() {
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
		// TODO Auto-generated method stub
		String uid = request.getParameter("userid");
		int userid=Integer.parseInt(uid);
		 String username = request.getParameter("username");
		 mdjavhash md1=new mdjavhash();
		 String psw = request.getParameter("password");
		 String hashpswString = null;
		 try {
			 hashpswString = md1.getHashPass(psw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String email=request.getParameter("email");
		 String fname = request.getParameter("firstname");
		 String lname = request.getParameter("lastname");
		 RegistrationPage register = new RegistrationPage(userid,fname,lname,email,username,hashpswString);
		 
		 RegistrationService rs = new RegistrationService();
		 Boolean result=rs.updateuser(register);
		 if (result) {
			 System.out.println("Login successfully");
			 request.getRequestDispatcher("updatesuccess.html").forward(request, response);	
		}
		 System.out.println("Error");
		//doGet(request, response);
	}

}
