package week3.mandatory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurence {

	public static void main(String[] args) {
		String input="welcome to Selenium automation";
		char[] charArray = input.toCharArray();
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for (int i = 0; i < charArray.length; i++) {
			
			if(!map.containsKey(charArray[i])) {
				map.put(charArray[i], 1);
			}else {
				int value=map.get(charArray[i]);
				value+=1;
				map.put(charArray[i], value);
				
			}
			
		}
		System.out.println(map);
	}

}
