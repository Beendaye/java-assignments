package homework.day09;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame implements Game{

	@Override
	public void start() {
		 Scanner scan = new Scanner(System.in);
		 Random rand = new Random();
		 
		 System.out.println("[가위바위보 게임 시작]");
		 System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요.");
		 
		 int userChoice = scan.nextInt();
		 int comChoice = rand.nextInt(3);
		 
		 if(userChoice == comChoice) {
			 System.out.println("비겼습니다.");
		 } else if ((userChoice == 0 && comChoice == 2) ||
				    (userChoice == 1 && comChoice == 0) ||
				    (userChoice == 2 && comChoice == 1)) {
			 
			 System.out.println("이겼습니다.");
		 } else {
			 System.out.println("졌습니다.");
		 }
	}

}
