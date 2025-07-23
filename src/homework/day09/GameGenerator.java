package homework.day09;

import java.util.Scanner;

public class GameGenerator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Game game = null;
		
		System.out.println("실행할 게임을 선택하세요");
		System.out.println("1. 홀짝 게임");
		System.out.println("2. 가위바위보 게임");
		System.out.println("3. 주사위 맞추기 게임");
		System.out.println("------------------");
		System.out.print("게임 선택 : ");
		int choice = scan.nextInt();
		
		System.out.println();
		
		if(choice == 1) {
			game = new OddEvenGame();
		} else if (choice == 2) {
			game = new RockPaperScissorsGame();
		} else if (choice == 3) {
			game = new DiceGame();
		} else { // 다른 거 입력 시
			System.out.println("잘못된 선택입니다.");
		}
		
		if(game != null) {
			game.start();
		}
		
	}

}
