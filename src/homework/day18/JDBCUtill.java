package homework.day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtill {
	static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() throws SQLException {
		return DriverManager.getConnection(bundle.getString("url"),
										   bundle.getString("username"),
										   bundle.getString("password")
										   );
		
	}
	
	public static void close(Connection conn, // DB에 접속 성공 시 생성되는 객체
			                 Statement stmt,  //
			                 ) {
		
	}
}
