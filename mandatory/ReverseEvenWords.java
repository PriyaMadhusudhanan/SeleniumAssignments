package week1.day2.assignments.mandatory;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] word=test.split(" ");
		for (int i = 0; i < word.length; i++) {
			if(i%2!=0) {
				char[] chars=word[i].toCharArray();
				for (int j = chars.length-1; j>=0 ; j--) {
					System.out.print(chars[j]);
				}
				System.out.print(" ");
			}
			else {
				System.out.print(word[i]+" ");
			}
		}
	}
}
