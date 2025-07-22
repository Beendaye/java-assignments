package homework.day07;

import java.util.Scanner;

public class RandomBall {
	
	// Field
	// 배열 저장
	int count = 3;
	int[] comArr = new int[count];
	int[] inputArr = new int[count];
	
	// Constructor
	
	// Method
	// 컴퓨터 랜덤숫자 생성
	void comRandom() {
		for(int i=0; i<comArr.length;i++) {
			comArr[i] = (int) (Math.random() * 10);
		}
	}
	
	// 사용자 입력
	void userInput() {
		Scanner scan = new Scanner(System.in);
		
		/* **********************
		 * 반복문 어떤 것을 쓸 것인가?!
		 * 1) for : 반복횟수가 명확할 때
		 * 2) while : 반복횟수를 알 수 없을 때(ex. 조건이 true일동안 무한 반복)
		 * 3) do-while : while문과 거의 같지만 무조건 한 번은 실행해야 할 때
		 * 
		 * 조건문은 어떤 것을 쓸 것인가?!
		 * 1) if : 복잡한 조건과 범위 판단이 포함될 때, 논리연산이 포함될 때
		 * 2) switch : 딱 떨어지는 선택지, boolean 타입은 사용 불가
		 * */
		comRandom();

		while(true) {
			// 사용자가 번호 3개 입력
			System.out.println("번호를 입력해주세요.");
			
			
		}
		
		
	}
	
}
