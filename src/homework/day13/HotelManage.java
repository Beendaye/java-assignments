package homework.day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelManage {
	private Scanner scan;
	private Map<String, Room> roomManageMap;
	
	public HotelManage() {
		scan = new Scanner(System.in);
		roomManageMap = new HashMap<String, Room>();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 " + " 2.체크아웃 " + " 3.객실상태 " + " 4.업무종료");
		System.out.println("*************************************************");
		System.out.print("업무 선택 >> ");
	}
	
	public void roomManageStart() {
		System.out.println("*******************************");
		System.out.println("안녕하세요? 호텔의 문이 열렸습니다:>");
		System.out.println("*******************************");
		
		while(true) {
			displayMenu();
			
			int menuNum = scan.nextInt();
			
			switch(menuNum) {
				case 1 : insert();  // 체크인
					break;
				case 2 : delete();  // 체크아웃
					break;
				case 3 : search();  // 객실상태
					break;
				case 0 : 
					System.out.println("*******************************");
					System.out.println("안녕히가세요.");
					System.out.println("*******************************");
					return;
				default : 
					System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	private void insert() {
		System.out.println();
		System.out.println("어느 방에 체크인하시겠습니까?");
		System.out.print("룸넘버 입력 >> ");
		String roomNum = scan.next();
		System.out.println();
		System.out.println("누구를 체크인하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String guest = scan.next();
		
		if(roomManageMap.get(roomNum) != null) {
			System.out.println(roomNum + "호에는 이미 사람이 있습니다.");
			return;
		}
		
		Room room = new Room(roomNum, guest);
		
		roomManageMap.put(roomNum, room);
		
		
	}
	
	private void delete() {}
	
	private void search() {}
}
