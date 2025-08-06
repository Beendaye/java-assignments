package homework.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 실행
public class HorseRace {

	
	public static void main(String[] args) {
		// List로 저장
		List<Horse> horseList = new ArrayList<Horse>();
		
		RaceState rs = new RaceState(horseList);
		
		// 데이터 추가
		for(int i=1;i<=10;i++) {
			String num = String.format("%02d번말", i); // 숫자 자릿수 맞추기
			horseList.add(new Horse(num));
		}
		
		for(Horse h : horseList) {
			h.start();
		}
		
		rs.start();
		
		for(Horse h : horseList) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			rs.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//정렬
		Collections.sort(horseList);
		
		System.out.println();
		System.out.println("경기가 종료되었습니다.");
		System.out.println("=================");
		System.out.println("순위\t경주마");
		System.out.println("-----------------");
		
		for(Horse hor : horseList) {
			System.out.println(hor);
		}
	}

}

// 말
class Horse extends Thread implements Comparable<Horse> {
	
	//Field
	public static int currRank = 1;
	
	private String hName;
	private int rank;
	private int crrLocation;
	
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
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getCrrLocation() {
		return crrLocation;
	}

	public void setCrrLocation(int crrLocation) {
		this.crrLocation = crrLocation;
	}

	
	@Override
	public String toString() {
		return rank + "등\t" + hName;
	}

	//스레드 실행
	//1~50구간 말 뛰게 하기
	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			crrLocation = i;
			//System.out.println(hName + "의 현재 위치 : " + i);
			try {
				Thread.sleep((int)(Math.random() * 301) + 200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		//System.out.println(hName + "경기종료");
		
		currRank++;
		rank = currRank;
		
	}
	/*
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(hName + " : ");
			
			for(int j=0;j<i;j++) {
				System.out.print("-");
			}
			
			System.out.print(">");
			
			for(int k=0;k<49-i;k++) {
				System.out.print("-");
			}
			
			System.out.println();
			
			try {
				Thread.sleep((int)(Math.random() * 301) + 200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(hName + "경기종료");
		
		setRank(HorsePlay.currRank++);
		
	}*/

	// 오름차순 정렬하기
	@Override
	public int compareTo(Horse h) {
		return Integer.compare(this.getRank(), h.getRank());
	}
}

// 경주
/*
01번말 --->------------------------------------
02번말 ----->----------------------------------
...
*/
class RaceState extends Thread {
	private List<Horse> horseList;

	public RaceState(List<Horse> horseList) {
		super();
		this.horseList = horseList;
	}
	

	@Override
	public void run() {
		while(true) {
			
			if(Horse.currRank == horseList.size()) {
				break;
			}
			
			for(int i=0;i<horseList.size();i++) {
				Horse h = horseList.get(i);
				System.out.println(h.gethName() + " : ");
				
				for(int j=1;j<=50;j++) {
					if(j==h.getCrrLocation()) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				
				System.out.println();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}