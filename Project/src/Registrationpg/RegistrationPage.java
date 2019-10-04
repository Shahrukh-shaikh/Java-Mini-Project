package Registrationpg;

public class RegistrationPage {
	
	private int userid;
	private String fname ;
	private String lname;
	private String email ;
	private String username ;
	private String psw;
	
	
	public RegistrationPage(int userid,String fname, String lname, String email, String username, String psw) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.psw = psw;
	}
	


	public RegistrationPage() {
		super();
	}



	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}


	@Override
	public String toString() {
		return "RegistrationPage [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", username=" + username + ", psw=" + psw + "]";
	}


	
	
	

}
