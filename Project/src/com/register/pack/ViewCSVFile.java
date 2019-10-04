package com.register.pack;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class ViewCSVFile
 */
@WebServlet("/viewCSV")
public class ViewCSVFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCSVFile() {
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
		//doGet(request, response);
		RegistrationService rs3=new RegistrationService();
		
		List<RegistrationPage> list = rs3.CSVview();
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("List.jsp");
		view.forward(request, response);
		
		//List<Product> products = dao.getAll();
		//request.setAttribute("products", products);
		//RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		//view.forward(request, response);
		

	}

}
