package homework.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentGradeList {

	public static void main(String[] args) {
		
		List<Student> stdList = new ArrayList<Student>();
		
		// 학생 및 성적 정보 리스트 => 정렬을 위해 순서 섞음
		stdList.add(new Student("11108001","강민수",60,40,55));
		stdList.add(new Student("11108003","박서준",75,98,85));
		stdList.add(new Student("11108002","김다은",92,86,97));
		stdList.add(new Student("11108005","서유리",84,86,88));
		stdList.add(new Student("11108004","배지훈",46,32,26));
		
		System.out.println("===============\n  학생 성적 정보  \n===============");
		
		Collections.sort(stdList);
		
		for(Student std : stdList) {
			System.out.println(std);
		}
		
		System.out.println();
		
		System.out.println("===============\n  학생 등수 정보  \n===============");
		
		Collections.sort(stdList, new ScoreRankDesc());
		
		int rank = 1;
		for(int i;i<stdList.size();i++) {
			System.out.println(i + ":" + stdList.get);
		}
		
	}

}
