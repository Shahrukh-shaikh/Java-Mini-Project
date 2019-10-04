package ProjectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.descriptor.web.LoginConfig;



import ConnectionUtilities.DBConnection;
import Registrationpg.RegistrationPage;
import oracle.net.aso.e;
import sun.util.logging.resources.logging;

public class RegistrationDao {

	Logger logger = org.apache.log4j.LogManager.getLogger(RegistrationDao.class);
	
	public int createUser(RegistrationPage register) {
		
		try {
			
			Connection conn = DBConnection.open();
			String query = "Insert into Register(userid,fname,lname,email,username,psw) Values(?,?,?,?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setInt(1, register.getUserid());
		
			pstat.setString(2, register.getFname());
			pstat.setString(3, register.getLname());
			
			pstat.setString(4, register.getEmail());
			pstat.setString(5, register.getUsername());
			pstat.setString(6, register.getPsw());
			int result = pstat.executeUpdate();
			
			return result;
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return 0;

		
		
	}
	
	
	public boolean Authenticateus(String username,String psw) {
		try {
			Connection conn= DBConnection.open();
			String query = "Select psw from Register where username=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,username);
			ResultSet rst = stmt.executeQuery();
			if (rst.next()) {
				String pass = rst.getString("psw");
				
				if (psw.equals(pass)) {
					logger.info(username);

					return true;
					//System.out.println("Login Successfully");
				}else {
					//System.out.println("Invalid credentials");
					return false;
				}
				
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return false;
		
	}
	
	public int InsertCSV(List<RegistrationPage> list) {
	
		Connection conn;
		int total = 0;
		try {
			conn = DBConnection.open();
			for (int i = 0; i <list.size(); i++) {
				String query = "Insert into Register(userid,fname,lname,email,username,psw) Values(?,?,?,?,?,?)";
				PreparedStatement pstat = conn.prepareStatement(query);
				pstat.setInt(1, list.get(i).getUserid());
				pstat.setString(2, list.get(i).getFname());
				pstat.setString(3, list.get(i).getLname());
				pstat.setString(4, list.get(i).getEmail());
				pstat.setString(5, list.get(i).getUsername());
				pstat.setString(6, list.get(i).getPsw());
				int result = pstat.executeUpdate();
				total= total+result;
				
			
			}
			return total;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}
	
	public List<RegistrationPage> CSVview() {
		try {
			Connection conn = DBConnection.open();
			String query = "Select * from Register";
			Statement stmnt =  conn.createStatement();
			ResultSet result = stmnt.executeQuery(query);
			
		
			
			 List<RegistrationPage> list = new ArrayList<>();
		        while (result.next()) {
		        list.add(new RegistrationPage(result.getInt("userid"), result.getString("fname"), result.getString("lname"), result.getString("email"), result.getString("username"), result.getString("psw")));
		       //   list.add(new RegistrationPage());
		        }
		        return list;
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return null;
		
	}
	
	public boolean Authenticateadmin(String username,String psw) {
		try {
			Connection conn= DBConnection.open();
			String query = "Select psw from Adminlogin where username=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,username);
			ResultSet rst = stmt.executeQuery();
			if (rst.next()) {
				String pass = rst.getString("psw");
				
				if (pass.equals(psw)) {
					return true;
					
				}else {
					//System.out.println("Invalid credentials");
					return false;
				}
				
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return false;		
		
	}
	
	public boolean update(RegistrationPage register) {
		try {
			Connection conn= DBConnection.open();
			String query = "Update Register set userid=?,fname=?, lname=?, email=?, psw=? where username=?";
			PreparedStatement pstat= conn.prepareStatement(query);
			pstat.setInt(1, register.getUserid());
			pstat.setString(2, register.getFname());
			pstat.setString(3, register.getLname());
			pstat.setString(4, register.getEmail());
			pstat.setString(5, register.getPsw());
			pstat.setString(6, register.getUsername());
			int i = pstat.executeUpdate();
			if (i>0) {
				return true;
				
			}else {
				return false;
			}
		

		} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
		}finally {
			DBConnection.close();
		}
		return false ;
		
	}
	
	/*public static RegistrationPage getUser(String username){  
        RegistrationPage e=new RegistrationPage();  
          
        try{  
            Connection con=DBConnection.open();  
            PreparedStatement ps=con.prepareStatement("select * from register where uname=?");  
            ps.setString(1,uname);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setFname(rs.getString(1));  
                e.setLname(rs.getString(2));
                e.setPno(rs.getInt(3));
                e.setdesignation(rs.getString(4));  
                e.setEmail(rs.getString(5));  
                e.setPassword(rs.getString(6));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e; */
	

	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
		
	
		

	
	
	


