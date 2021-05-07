package week3.mandatory;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		Map<Integer,String> map=new TreeMap<Integer,String>(Collections.reverseOrder());
		map.put(100, "Hari");
		map.put(101, "Naveen");
		map.put(102, "Sam");
		map.put(104, "Balaji");
		System.out.println(map);

	}

}
