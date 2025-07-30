 package homework.day10;

import java.util.Comparator;

public class ScoreRankDesc implements Comparator<Student> {

	@Override
	public int compare(Student std1, Student std2) {
		
		if(std1.getTotal() == std2.getTotal()) {
			return std1.getStudentId().compareTo(std2.getStudentId()) * -1;
		}
		
		return Integer.compare(std1.getTotal(), std2.getTotal()) * -1; // 총점 내림차순
	}

}
