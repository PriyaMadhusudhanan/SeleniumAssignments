package week3.mandatory;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String input= "PayPal India";
		Set<Character> charSet=new LinkedHashSet<Character>();
		Set<Character> dupCharSet=new LinkedHashSet<Character>();
		
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if(!charSet.contains(charArray[i])) {
				charSet.add(charArray[i]);
				if(charArray[i]!=' ') {
					System.out.print(charArray[i]);
				}
				
			}else {
				dupCharSet.add(charArray[i]);
			}
		}

	}

}
