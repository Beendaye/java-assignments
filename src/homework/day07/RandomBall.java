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
			int randNum = (int) (Math.random() * 10); // 랜덤으로 숫자 뽑아서
			comArr[i] = randNum; // 배열에 저장
			
			// 중복 숫자 제거 ★★★ 이해하고 작성해볼것 
		}
		
		System.out.println("숫자가 정해졌습니다.");
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
		
		System.out.println("3개의 번호를 띄어쓰기로 하나씩 입력해주세요(예시: 1 2 3)");
		
		int gameCount = 0; // 반복 횟수 저장

		while(true) { // 실제 게임 반복문
			
			gameCount++; // 반복 횟수 증가
			
			// 사용자가 번호 3개 입력 + 배열에 저장
			System.out.println("-------------------");
			System.out.print("번호 3개 입력 : ");
			
			for(int i=0;i<inputArr.length;i++) {
				inputArr[i] = scan.nextInt();
			}
			
			// 결과에 출력해야 할 숫자 저장
			int strike = 0;
			int ball = 0;
			
			// 사용자와 컴퓨터 숫자 비교
			for(int j=0;j<comArr.length;j++) { // 컴퓨터 숫자 하나 선택
				for(int k=0;k<inputArr.length;k++) { // 사용자 숫자 하나 선택
					// 배열의 위치와 실제 값 비교
					if(j == k && comArr[j] == inputArr[k]) { // 위치와 값 모두 동일
						// 바깥 for문 한 번 돌 때 안쪽에서 3번 도니까 여기서 갯수 증가 시키기
						strike++;
					} else if(j != k && comArr[j] == inputArr[k]) { // 위치 또는 값 동일
						ball++;
					}
				}
			}
			
			System.out.println("\u261E " + strike + "S " + ball + "B");
			
			// 게임 종료 조건문
			if(strike == 3) {
				break;
			} else {
				strike = 0;
				ball = 0;
			}
			
		}
		
		System.out.println("===========================");
		System.out.println(gameCount + "번째에 성공하셨습니다.");
		
		
	}
	
}
