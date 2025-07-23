package homework.day09;

import java.util.Random;
import java.util.Scanner;

public class DiceGame implements Game {

	@Override
	public void start() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		 
		System.out.println("[주사위 맞추기 게임 시작]");
		System.out.println("1~6까지 숫자를 선택하세요.");
		 
		int userChoice = scan.nextInt();
		int diceNum = rand.nextInt(6) + 1; 
		
		System.out.println("주사위 숫자 : " + diceNum);
		
		if(userChoice == diceNum) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
	}

}
