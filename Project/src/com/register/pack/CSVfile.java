package com.register.pack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Encryptionmd5.RPwd;
import Encryptionmd5.mdjavhash;
import RegistrationService.RegistrationService;
import Registrationpg.RegistrationPage;

/**
 * Servlet implementation class CSVfile
 */
@WebServlet("/uploadCSV")
public class CSVfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSVfile() {
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
		
		RegistrationService rs1=new RegistrationService();
		
		List<RegistrationPage> list = readCSV();
		int result1 = rs1.InsertCSV(list);
		if (result1==list.size()) {
			//System.out.println("Csv file inserted");
			request.getRequestDispatcher("servlet.html").forward(request, response);
		}
		System.out.println(list.get(0));
		
		
		//List<RegistrationPage> list2 = CSVfile.
		//CSVFile csvFile = new CSVFile();
		//List<RegistrationPage> liste = CSVFile.readCSV();
		//doGet(request, response);
	}
	public static List<RegistrationPage> readCSV() {
		
		RPwd pass= new RPwd();

        String csvFile = "C:\\javaexample\\workspace\\AccendProject\\Project\\userdetails.csv";
        List<RegistrationPage> list = new ArrayList<RegistrationPage>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            try {
				while ((line = br.readLine()) != null) {

				    // use comma as separator
					mdjavhash md= new mdjavhash();
				    String[] userdetails = line.split(cvsSplitBy);
				   String username= userdetails[1].charAt(0)+userdetails[2];
				    RegistrationPage reg=null;
					try {
						reg = new RegistrationPage(Integer.parseInt(userdetails[0]), userdetails[1],  userdetails[2],  userdetails[3],  username, pass.getAlphaNumericString(8));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    list.add(reg);
				   

				    //System.out.println("User details [user id= " + userdetails[1] + " , First name= " + userdetails[2] + " , Last name= " + userdetails[3]+ ", Email= " + userdetails[4]);

				}
				
				return list;
				
					//System.out.println(list.get(0));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

 		}
	

	
	
}



