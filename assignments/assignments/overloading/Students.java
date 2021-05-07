package week3.day1.assignments.overloading;

public class Students {
	
	public void getStudentInfo(String id) {
		System.out.println("This method is having ID arguement alone, ID # is:"+id);
	}
	
	public void getStudentInfo(String id, String name) {
		System.out.println("This method is having ID and name arguements. ID # is:"+id+" and name is:"+name);
	}
	
	public void getStudentInfo(String email, long phoneNumber) {
		System.out.println("This method is having email and phoneNumber arguements. Email ID is:"+email+" and Phone number is:"+phoneNumber);
	}
	
	public static void main(String[] args) {
		Students s= new Students();
		s.getStudentInfo("11BCA124");
		s.getStudentInfo("11BCA124", "Priya.M");
		s.getStudentInfo("priya@gmail.com", 04441253211);

	}

}
