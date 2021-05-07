package week3.day1.assignments.bank;

public class AxisBank extends BankInfo{
	
	public void deposit() {
		System.out.println("This is deposit method from AxisBank class");
	}
	
	public static void main(String[] args) {
		AxisBank ab=new AxisBank();
		ab.saving();
		ab.fixed();
		ab.deposit();
	}
	
	
}
