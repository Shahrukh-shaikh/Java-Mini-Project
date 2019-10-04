package ConnectionUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private static Connection conn;
	private final static String driver="oracle.jdbc.driver.OracleDriver";
	private final static String url="jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
	private final static String username="ssheikh";
	private final static String pass="ssheikh";
	//private static final Connection Connection = null;
	
	public static Connection open() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		 conn = DriverManager.getConnection(url,username,pass);
		 return conn;
		
	}
	public static void close() {
		try {
			if(conn !=null);
			conn.close();
		}catch (SQLException e) {
			System.out.println("Problem while clossing database");
		}
	}

}
