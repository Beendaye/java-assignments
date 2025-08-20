package homework.day18;

import java.sql.Connection;       // 데이터베이스와의 연결을 표현하는 객체. sql과 연계하려면 무조건 필요.
import java.sql.DriverManager;    // DB 연결을 생성해주는 팩토리 클래스 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;     // DB 관련 작업 중 발생하는 모든 예외
import java.sql.Statement;   	 // SQL 실행 도구 객체
import java.util.ResourceBundle;

public class JDBCUtil {
	static ResourceBundle bundle;
	
	static { // JVM에 로딩될 때 단 한 번만 실행
		bundle = ResourceBundle.getBundle("db");
		
		try {
			// 1. Drive 로드
			Class.forName(bundle.getString("driver")); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * connection 생성
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnetion() throws SQLException {
		return DriverManager.getConnection(bundle.getString("url"),
										   bundle.getString("username"),
										   bundle.getString("password")
										   );
		
	}
	
	
	/**
	 * 자원 반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, 
			                 Statement stmt,
			                 PreparedStatement pstmt,
			                 ResultSet rs
			                 ) {
		if(rs != null) try {rs.close();} catch(SQLException ex) {}
		if(stmt != null) try {stmt.close();} catch(SQLException ex) {}
		if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
		if(conn != null) try {conn.close();} catch(SQLException ex) {}
	}
}
