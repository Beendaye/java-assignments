package homework.day10;

public class Student implements Comparable<Student> {
	//Field
	private String studentId; // 학번
	private String studentName; // 이름
	private int kors, engs, maths; // 점수
	private int total; // 총점
	private int rank; // 등수
	
	//Constructor
	public Student(String studentId, String studentName, int kors, int engs, int maths) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.kors = kors;
		this.engs = engs;
		this.maths = maths;
		this.total = kors + engs + maths;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return getStudentId() + " " + studentName  +
			   " | 국어 : " + kors + 
			   " | 영어 : " + engs + 
			   " | 수학 : " + maths +
			   " => 총점 : " + total;
	}

	@Override
	public int compareTo(Student otherStd) {
		return getStudentId().compareTo(otherStd.getStudentId());
	}

}

