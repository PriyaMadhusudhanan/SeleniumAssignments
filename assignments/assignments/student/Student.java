package week3.day1.assignments.student;

import week3.day1.assignments.department.Department;

public class Student extends Department {
	
	public void studentName() {
		System.out.println("This is studentName method from Student class and student package");
	}
	
	public void studentDept() {
		System.out.println("This is studentDept method from Student class and student package");
	}

	public void studentId() {
		System.out.println("This is studentId method from Student class and student package");
	}
	
	public static void main(String[] args) {
		Student s = new Student();
		s.studentName();
		s.studentDept();
		s.studentId();
		s.deptName();
		s.collegeName();
		s.collegeCode();
		s.collegeRank();
	}
}
