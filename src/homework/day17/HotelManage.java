package homework.day17;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManage {
	private Scanner scan;
	private Map<String, Room> roomManageMap;
	
	//file
	private static final File FILE_DATA = new File("d:/D_Other/hotelMng.bin");
	
	public HotelManage() {
		scan = new Scanner(System.in);
		roomManageMap = new HashMap<String, Room>();
		loadFromFile();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 " + " 2.체크아웃 " + " 3.객실상태 " + " 4.업무종료");
		System.out.println("0.임시데이터 삽입");
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
				case 1 : checkIn();  // 체크인
					break;
				case 2 : checkOut();  // 체크아웃
					break;
				case 3 : search();  // 객실상태
					break;
				case 4 : 
					System.out.println("*******************************");
					System.out.println("호텔 문을 닫습니다.");
					System.out.println("금일 객실 정보를 저장합니다.");
					System.out.println("*******************************");
					
					saveToFile();
					
					return;
				case 0 : sampleData(); // 샘플 데이터 삽입
					break;
				default : 
					System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	private void checkIn() {
		System.out.println();
		System.out.println("어느 호실을 체크인하시겠습니까?");
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
		
		System.out.println("체크인 되었습니다.");
		
	}
	
	private void checkOut() {
		//delete
		System.out.println();
		System.out.println("어느 호실을 체크아웃하시겠습니까?");
		System.out.print("룸넘버 입력 >> ");
		String roomNum = scan.next();
		
		if(roomManageMap.get(roomNum) == null) {
			System.out.println(roomNum + "호에는 체크인한 사람이 없습니다.");
		} else {
			roomManageMap.remove(roomNum);
			System.out.println("체크아웃 되었습니다.");
		}
	}
	
	private void search() {
		System.out.println("====================");
		System.out.println("룸넘버\t투숙객");
		System.out.println("====================");
		
		Set<String> roomKey = roomManageMap.keySet();
		
		if(roomKey.size() == 0) {
			System.out.println("현재 체크인된 호실이 없습니다.");
		} else {
			for(String roomNum : roomKey) {
				Room r = roomManageMap.get(roomNum);
				System.out.println(r.getRoomNum() + "\t" + r.getGuest());
			}
		}
	}
	
	/**
	 * 파일로 저장 
	 */
	private void saveToFile() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_DATA))
				) {
			oos.writeObject(roomManageMap);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 저장한 객체 읽어와 출력하기
	 */
	@SuppressWarnings("unchecked")
	private void loadFromFile() {
		if(!FILE_DATA.exists()) return; // exists() => 해당 경로에 파일이 있는지 확인
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_DATA))
				) {
			roomManageMap = (Map<String,Room>) ois.readObject();
		} catch (EOFException ex) {
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) { // 클래스를 찾을 수 없을 때 예외
			e.printStackTrace();
		}
	}
	
	/**
	 * 임시 데이터
	 */
	private void sampleData() {
		roomManageMap.put("201", new Room("201", "강호동"));
		roomManageMap.put("202", new Room("202", "김동현"));
		roomManageMap.put("203", new Room("203", "유병재"));
		roomManageMap.put("204", new Room("204", "고경표"));
		roomManageMap.put("205", new Room("205", "변백현"));
		roomManageMap.put("206", new Room("206", "여진구"));
		
		System.out.println("샘플데이터가 삽입되었습니다.");
	}
}
