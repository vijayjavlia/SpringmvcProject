package misreportportal.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateZgames {

	
	
	
	
	
	
	
	public static Connection getDatabse() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndoto?serverTimezone=UTC&autoReconnect=true", "root","gloadmin123");
//			
			conn = DriverManager.getConnection(
					"jdbc:mysql://5.189.169.12:3306/9mob_dubai?serverTimezone=UTC&autoReconnect=true", "root",
					"gloadmin123");
			System.out.println("gamedubai DB connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getDatabse57() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/misreport?serverTimezone=UTC&autoReconnect=true", "root","genr@&y&123");
//			
			conn = DriverManager.getConnection(
					"jdbc:mysql://5.189.146.57:3306/misreport?serverTimezone=UTC&autoReconnect=true", "root","genr@&y&123");
			
			System.out.println("misreport DB connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
