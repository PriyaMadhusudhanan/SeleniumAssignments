package week1.day2.assignments.mandatory;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a1={3,2,11,4,6,7};
		int[] a2={1,2,8,4,9,7};
		System.out.print("Intersection of the given string is: {");
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				if(a1[i]==a2[j]) {
					System.out.print(a1[j]);
					if(j!=a2.length-1) {
						System.out.print(",");
					}
				}
				
			}
			
		}
		System.out.print("}");
	}

}
