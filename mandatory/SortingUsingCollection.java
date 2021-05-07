package week3.mandatory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingUsingCollection {

	public static void main(String[] args) {
		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		List<String> list=new ArrayList<String>();
		
		for (int i = 0; i < input.length; i++) {
			list.add(input[i]);
		}
		
		Collections.sort(list);
		
		for(int j=list.size()-1;j>=0;j--) {
			String output=list.get(j);
			System.out.println(output);
		}
		
	}

}
