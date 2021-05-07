package week3.day1.assignments.polymorphism;

public class Calculator {

	public static void main(String[] args) {
		Calculator c=new Calculator();
		c.add(7, 3);
		c.add(10, 2, -3);
		c.multiply(10, 5);
		c.multiply(3, 3.7502);
		c.subtract(-3, -4);
		c.subtract(91.0523648, 85.024862);
		c.divide(70, 5);
		c.divide(852.369852, 2);

	}
	
	public void add(int num1,int num2) {
		System.out.println(num1+num2);
	}
	public void add(int num1,int num2,int num3) {
		System.out.println(num1+num2+num3);
	}
	
	public void multiply(int num1,int num2) {
		System.out.println(num1*num2);
	}
	public void multiply(int num1,double num2) {
		System.out.println(num1*num2);
	}
	public void subtract(int num1,int num2) {
		System.out.println(num1-num2);
	}
	public void subtract(double num1,double num2) {
		System.out.println(num1-num2);
	}
	public void divide(int num1,int num2) {
		System.out.println(num1/num2);
	}
	public void divide(double num1,int num2) {
		System.out.println(num1/num2);
	}

}
