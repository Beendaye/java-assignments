package homework.day15;

import java.util.ArrayList;
import java.util.List;

public class HorsePlay {

	public static void main(String[] args) {
		List<Horse> horseList = new ArrayList<Horse>();
		horseList.add(new Horse("1번말"));
		horseList.add(new Horse("2번말"));
		horseList.add(new Horse("3번말"));
		horseList.add(new Horse("4번말"));
		horseList.add(new Horse("5번말"));
		horseList.add(new Horse("6번말"));
		horseList.add(new Horse("7번말"));
		horseList.add(new Horse("8번말"));
		horseList.add(new Horse("9번말"));
		horseList.add(new Horse("10번말"));
		
		for(Thread th : horseList) {
			th.start();
		}
	}

}

class Horse extends Thread {
	
	//Field
	private String hName;
	private int Rank;
	
	//Constructor
	public Horse(String hName) {
		super();
		this.hName = hName;
	}
	
	//Method
	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int rank) {
		Rank = rank;
	}
	
	//스레드 실행
	@Override
	public void run() {
		for(int i=1; i<=50;i++) {
			System.out.println(i);
		}
	}
}
