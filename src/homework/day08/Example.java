package homework.day08;

import java.util.Random;
import java.util.Scanner;

public class Example {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      int menu = 0;
      int money = 0;
      int lottoMoney = 1000;
      int change = 0;
      int lottoCount = 0;
      int[] lotto = new int[6];
      
      while(true) {
         System.out.println("===============Lotto 프로그램===============");
         System.out.println("1. Looto 구입");
         System.out.println("2. 프로그램 종료");
         System.out.print("메뉴를 선택해주세요.");
         menu = scan.nextInt();
         if(menu == 1) {
            System.out.print("구매할 금액을 입력해주세요.");
            money = scan.nextInt();
            
            //금액 계산
            // 로또 횟수
            lottoCount = money/lottoMoney;
            // 잔돈 (나머지)
            change = money % lottoMoney;     
            
            if(lottoCount < 1) {
               System.out.println("로또 금액은 최소 1000원입니다.");
            }else {
               System.out.println("행운의 로또번호는 아래와 같습니다.");
               for(int k = 0; k < lottoCount; k++) {
                  //로또 번호 생성 
                  lotto = lottoGenerator();
                  System.out.print("로또번호" + (k+1) + ": ");   
                  for (int n : lotto) {
                      System.out.print(n + " ");
                    }
                  System.out.println(" ");
               }
               
               System.out.print("받은 금액은 " + money + "원이고" + "거스름돈은 " + change + "원 입니다.");
               break;
            }
            
         }else if(menu == 2) {
            System.out.print("프로그램을 종료하겠습니다.");
            break;
         }else {
            System.out.print("프로그램에 존재하지 않는 메뉴입니다. 프로그램을 종료하겠습니다.");
            break;
         }
      }
   }
   
   public static int[] lottoGenerator() {
        int[] lotto = new int[6];         // 로또 번호를 저장할 배열
        Random random = new Random();

        for (int i = 0; i < lotto.length; i++) {
            int num = random.nextInt(45) + 1;  // 1~45 사이의 난수 생성
            boolean isDuplicate = false;

            // 중복 확인
            for (int j = 0; j < i; j++) {
                if (lotto[j] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            // 중복이 아니면 배열에 저장
            if (!isDuplicate) {
                lotto[i] = num;
            }
        }

        return lotto;
   }

}
