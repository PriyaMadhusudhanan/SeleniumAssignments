package week3.day1.assignments.system;

public class Desktop extends Computer{
	
	public static void main(String[] args) {
		
		Desktop com=new Desktop();
		
		com.computerModel();
		com.desktopSize();
		
	}
	
	public void desktopSize() {
		 System.out.println("This is desktopSize method from Desktop class"); 
	}
	
}
