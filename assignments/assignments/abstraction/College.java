package week3.day1.assignments.abstraction;

public class College extends University{
	
	public static void main(String[] args) {
		College c=new College();
		c.pg();
		c.ug();
	}

	@Override
	public void ug() {
			System.out.println("This is ug abstract method having implementaions in College class");
	}

}
