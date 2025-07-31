package homework.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
			
			System.out.println();
			// 선택지 조건문
			if(selNum == 1) {
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
				Random random = new Random();
								
				for(int i=0;i<lottoCount;i++) {
					// 중복없이 랜덤번호 뽑기
					Set<Integer> randNum = new HashSet<>();
					
					while(randNum.size()<6) {
						int num = random.nextInt(45) + 1;
						randNum.add(num);
					}	
					
					System.out.print((i+1) +"번째 Lotto 번호 : ");
					// list 만들어서 배열 저장
					List<Integer> lottoArr = new ArrayList<Integer>(randNum);
					
					Collections.sort(lottoArr);
					
					for(Integer num : lottoArr) {
						System.out.print(num + " ");
					}
					System.out.println(); 
				}

				System.out.println("------------------------------");
				System.out.println("지불하신 금액은 " + money + "원, 거스름돈은 " + change + "원 입니다.");
				System.out.println();
				
			} else if(selNum == 2) {
				break;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
				System.out.println();
			}
			
		} while(true);
		
		System.out.println("프로그램이 종료되었습니다, 감사합니다.");
	}

}