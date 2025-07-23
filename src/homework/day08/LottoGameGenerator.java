package homework.day08;

import java.util.Random;
import java.util.Scanner;

public class LottoGameGenerator {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 반복문 시작
		do {
			// A. 인트로
			// 사용자가 1번과 2번 중에 값을 직접 입력하여 선택한다.
			System.out.println("==============================");
			System.out.println("         LOTTO Program        ");
			System.out.println("------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==============================");
			System.out.print("선택 번호 : ");
			int selNum = scan.nextInt(); // 사용자 직접 입력
			
			// 선택지 조건문
			if(selNum == 2) {
				break;
			}
			// 조건문 종료
			
			System.out.println();
			
			// B. 프로그램 시작
			// 1) lotto 구입
			System.out.println("Lotto를 구입해주세요");
			System.out.println("얼마에 구입하겠습니까?(한 장당 1000원)");
			System.out.print("금액(원) : ");
			int money = scan.nextInt(); // 금액입력
			int lottoCount = money / 1000; // 구매 장 수 계산
			int change = money % 1000; // 잔돈 계산
			
			System.out.println("------------------------------");
			
			// 2) 구매한 장 수에 따른 Lotto 번호 랜덤 생성
			// 2-1) 배열 생성
			int[][] lottoArr = new int[lottoCount][6];
			Random random = new Random(); // random 객체 사용하기
			// 2-2) Lotto 번호 생성(반복문)
			for(int i=0;i<lottoCount;i++) { // 몇 번 생성할 것인가
				System.out.print((i+1) +"번째 Lotto 번호 : ");

				for(int j=0;j<lottoArr[i].length;j++) { // 그 횟수 안에서 얼만큼 생성할 것인가
					int randNum = random.nextInt(45) + 1;
					lottoArr[i][j] = randNum;
					
					// 로또 번호 출력
					System.out.print(lottoArr[i][j] + " ");
					
					// 중복 확인
					boolean isDuplicate = false;
					
				}
				
				System.out.println();
			}
			
			System.out.println("------------------------------");
			System.out.println("지불하신 금액은 " + money + "원, 거스름돈은 " + change + "원 입니다.");

		} while(true);
		
		// 반복문 종료

		System.out.println("프로그램이 종료되었습니다, 감사합니다.");
	}

}

/*
(스캐너 객체 생성)
(반복문-while)
A. 인트로
사용자가 1번과 2번 중에 값을 직접 입력하여 선택한다.
(조건문)
1. Lotto 구입 > B.프로그램 시작
2. 프로그램 종료 > 프로그램 종료 (break)
(조건문 종료)

B. 프로그램 시작
"Lotto를 구입해주세요. (Lotto 하나 당 1000원)"

1) 사용자가 지불할 금액을 입력합니다. -- 지불한 금액 및 나머지 저장
"금액(원) : 사용자 입력" 

2) 지불한 금액을 토대로 Lotto 갯수를 구하고 -- 나누기 연산 -> 연산하여 나온 답(x)을 3번 배열에 담기

(반복문 - x만큼 반복)
3) Lotto 갯수에 맞춰 랜덤하게 번호를 생성 -- 요소가 6개인 2차원 배열을 만들기
4) 생성한 번호 출력
"Lotto 번호 : 랜덤번호"
(반복문 종료)

5) 지불한 금액과 나머지(거스름돈)를 출력합니다.

(반복문 종료)

C. 아웃트로
감사합니다.
*/