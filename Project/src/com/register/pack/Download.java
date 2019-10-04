package com.register.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class Download
 */
@WebServlet("/download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
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
		doGet(request, response);
		RegistrationService rs3=new RegistrationService();
		
		List<RegistrationPage> list = rs3.CSVview();
		request.setAttribute("list", list);

		  response.setHeader( "Content-Disposition", 
				  "attachment;filename=file.csv"	);
		  response.setContentType("text/csv");
		  PrintWriter out = response.getWriter();
		  for (int i = 0; i<list.size(); i++) {
			  out.println(list.get(i).getUsername()+","+list.get(i).getFname()+","+list.get(i).getLname()+","+list.get(i).getEmail()+","+list.get(i).getPsw());

		  }	  
	}
}


