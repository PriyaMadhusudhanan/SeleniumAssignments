package week1.day2.assignments.mandatory;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] chars = test.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(i%2!=0) {
				System.out.print(chars[i]);
			}else {
				String s= Character.toString(chars[i]);
				System.out.print(s.toUpperCase());
				
			}
			
		}
	}

}
