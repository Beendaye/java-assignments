package homework.score.exam02;

import java.util.Scanner;

public class ScoreRankClassUse {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int studentCount = 5;

		Student[] student = new Student[studentCount];

		System.out.println("====5명의 학생 성적 입력====");
		
		// 점수 입력
		for(int i=0;i<studentCount;i++) {

			student[i] = new Student();
			
			System.out.print("이름: ");
			student[i].name = scan.next();
			System.out.print("국어 : ");
			student[i].kors = scan.nextInt();
			System.out.print("영어 : ");
			student[i].engs = scan.nextInt();
			System.out.print("수학 : ");
			student[i].mats = scan.nextInt();

			student[i].scoreCalculator();

			System.out.println();
		}
		
		// 버블정렬
		for(int i=0;i<4;i++) {
			for(int j=0; j<4-i; j++) {			
				if(student[j].total<student[j+1].total) {
					
					Student temp = student[j]; 
					student[j] = student[j+1];
					student[j+1] = temp;
				}
			}
		}
		
		System.out.println("\n====성적결과====");
		
		// rank
		for(int i=0;i<studentCount;i++) {
			student[i].rank = i + 1;
			
			System.out.println(student[i].rank+"등 "+student[i].name+ " " + student[i].total + "점");
		}
		
	}
}
