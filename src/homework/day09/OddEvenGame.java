package homework.day09;

import java.util.Random;
import java.util.Scanner;

public class OddEvenGame implements Game {

	@Override
	public void start() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("[홀짝 게임 시작]");
		System.out.println("홀(1) 또는 짝(0)을 선택하세요 : ");
		int userChoice = scan.nextInt();
		int number = rand.nextInt(100);
		System.out.println("랜덤숫자 : " + number);
		
		if(number % 2 == userChoice) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
	}
	
}
