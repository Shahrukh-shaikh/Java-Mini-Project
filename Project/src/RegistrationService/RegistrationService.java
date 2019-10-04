package RegistrationService;
import java.sql.ResultSet;
import java.util.List;

import ProjectDao.RegistrationDao;
import Registrationpg.RegistrationPage;

public class RegistrationService {
	
	private static RegistrationDao dao = new RegistrationDao();
	private ResultSet res;
	
	public boolean addUser(RegistrationPage Register) {
		int result=dao.createUser(Register);	
		
		if (result == 1)
			return true;
		else
			return false;
	
	}
	
	
	
	public static boolean checklogin(String username,String psw) {
		boolean acd = dao.Authenticateus(username, psw);
		return acd;
	}
	
	public static int InsertCSV(List<RegistrationPage> list) {
		
		int result=dao.InsertCSV(list);
		return result;
	}
	
	public static List<RegistrationPage> CSVview() {
		List<RegistrationPage> result=dao.CSVview();
		return result;
	}
	
	public static boolean checkAdminlogin(String username,String psw) {
		boolean acd1 = dao.Authenticateadmin(username, psw);
		return acd1;
	}
	
	public static boolean updateuser(RegistrationPage register) {
		boolean suc=dao.update(register);
		return suc;
		
	}

	

	
	

}
