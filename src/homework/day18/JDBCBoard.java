package homework.day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import homework.day18.util.JDBCUtil;

public class JDBCBoard {

	private Connection conn; 
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in);
	
	
	// 작업 선택
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 보기");
		System.out.println("  2. 새글 작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	
	// 프로그램 시작 메서드
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = scan.nextInt();
			switch(choice) {
				case 1: // 전체 목록 보기
					selectAllView();
					break;
				case 2: // 새글 작성
					
					break;
				case 3: // 수정
					
					break;
				case 4: // 삭제
					
					break;
				case 5: // 검색
					
					break;
				case 6: // 종료
					System.out.println("작업을 마칩니다.");
					break;
				default: // 전체 목록 보기
					System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
			}
		} while(choice != 6);
	}
	
	/**
	 * 전체 회원정보 출력
	 */
	private void selectAllView() {
		
		System.out.println();
		System.out.println("================================================================");
		System.out.println("no\t제목\t\t작성자\t작성일\t내용");
		System.out.println("================================================================");
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "select * from jdbc_board"; // table 조회
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // sql 실행 (select 실행)
			
			while(rs.next()) { // .next()로 행을 하나씩 내려가면서 읽음
				int no = rs.getInt("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				LocalDate regDt = rs.getTimestamp("board_date").toLocalDateTime().toLocalDate();
				String content = rs.getString("board_content");
			
				System.out.println(no + "\t" + title + "\t\t" + writer + "\t" + regDt + "\t" + content);
			}
			
			System.out.println("------------------------------------------------------------");
			System.out.println("전체 회원 정보 출력 완료");
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}


	public static void main(String[] args) {
		JDBCBoard boardObj = new JDBCBoard();
		boardObj.start();
	}

}
