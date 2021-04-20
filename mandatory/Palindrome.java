package week1.day2.assignments.mandatory;

public class Palindrome {

	public static void main(String[] args) {
		
		String input="madam";
		String rev="";
		char[] chars = input.toCharArray();
		
		for (int i = chars.length-1; i>=0; i--) {
			rev=rev+chars[i];
		}

		if(input.equalsIgnoreCase(rev)) {
			System.out.println("The given string is Palindrome");
		}
		else {
			System.out.println("The given string is not Palindrome");
		}
	}

}
