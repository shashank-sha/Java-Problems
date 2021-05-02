package practise;

public class HR_CountingValleys {

	public static void main(String[] args) {
		String s = "DDUUUUDD";
		char[] charArr = s.toCharArray();
		boolean enteredValley = false;
		int noOfValleys = 0, curr_level = 0;
		for(int i = 0; i < charArr.length; i++) {
			if(curr_level == 0 && charArr[i] == 'U')
				enteredValley = false;
			else if(curr_level == 0 && charArr[i] == 'D')
				enteredValley = true;

			if(charArr[i] == 'U')
				curr_level++;
			else
				curr_level--;
			
			if(curr_level == 0 && enteredValley)
				noOfValleys++;
		}
		System.out.println(noOfValleys);
	}

}
