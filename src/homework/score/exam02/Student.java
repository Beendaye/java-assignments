package homework.score.exam02;

public class Student {
	String name;
	int kors;
	int engs;
	int mats;
	int total;
	double avg;
	
	int rank;
	
	/*계산*/
	void scoreCalculator() {
		total = kors + engs + mats;
		avg = total / 3;
		
		System.out.println("★ 총점 : " + total);
		System.out.printf("★ 평균 : %.1f\n",avg);
		
	}
}


