package homework.score.exam01;

import java.util.Scanner;

public class ScoreRankCalcurator {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int studentCount = 5;

		String[] names = new String[studentCount];
		int[] kors = new int[studentCount];
		int[] engs = new int[studentCount];
		int[] mats = new int[studentCount];
		int[] total = new int[studentCount];
		double[] avg = new double[studentCount];
		
		/* 이런 방법도 있어요!
		 * name만 string 타입이니까 따로 빼고
		 * 나머지는 숫자 타입이니까 배열로 뺴고
		 * */
		

		System.out.println("====5명의 학생 성적 입력====");
		
		// 점수 입력
		for(int i=0;i<studentCount;i++) {

			System.out.print("이름: ");
			names[i] = scan.next();
			System.out.print("국어 : ");
			kors[i] = scan.nextInt();
			System.out.print("영어 : ");
			engs[i] = scan.nextInt();
			System.out.print("수학 : ");
			mats[i] = scan.nextInt();

			total[i] = kors[i] + engs[i] + mats[i];
			avg[i] = (double) total[i] / 3;

			System.out.println("★ 총점 : " + total[i]);
			System.out.println("★ 평균 : " + Math.round(avg[i]*100)/10.0);

			System.out.println();
		}
		
		// 버블 정렬
		for(int i=0;i<4;i++) {
			for(int j=0; j<4-i; j++) {			
				if(total[j]<total[j+1]) {
					
					//이름
					String tempName = names[j]; 
					names[j] = names[j+1];
					names[j+1] = tempName;
					
					//국어점수
					int tempKor = kors[j]; 
					kors[j] = kors[j+1];
					kors[j+1] = tempKor;
					
					//영어점수
					int tempEng = engs[j]; 
					engs[j] = engs[j+1];
					engs[j+1] = tempEng;
					
					//수학점수
					int tempMath = mats[j]; 
					mats[j] = mats[j+1];
					mats[j+1] = tempMath;
					
					//총점
					int tempTotal = total[j]; 
					total[j] = total[j+1];
					total[j+1] = tempTotal;
					
					//평균
					double tempAvg = avg[j]; 
					avg[j] = avg[j+1];
					avg[j+1] = tempAvg;
				}
			}
		}
		
		System.out.println("\n====성적결과====");
		
		//rank 저장
		int[] rank = new int[studentCount];
		
		//rank
		for(int i=0;i<studentCount;i++) {
			rank[i] = i + 1;
			
			System.out.println(rank[i]+"등 "+names[i]+ " " + total[i] + "점");
		}
		
	}
}
