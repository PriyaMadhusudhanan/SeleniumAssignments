package week1.day2.assignments.mandatory;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String[] word=text.split(" ");
		for (int i = 0; i < word.length; i++) {
			for (int j = i+1; j < word.length; j++) {
				if(word[i].equalsIgnoreCase(word[j])) {
					count++;
				}			
			if(count>1){
				text=text.replace(word[i],"");
				count=0;
				}
			}
		}
		System.out.println(text);
	}
}