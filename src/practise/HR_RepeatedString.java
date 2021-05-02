package practise;

import java.util.HashMap;

public class HR_RepeatedString {

	public static void main(String[] args) {
		String s = "a";
		long n = 1000000000000l;
		int noOfAs = 0;
		char[] charArr = s.toCharArray();
		for(int i = 0; i < charArr.length; i++) {
			if(charArr[i] == 'a')
				noOfAs++;
		}
		
		long finalCountOfAs = (n / s.length()) * noOfAs;
		
		for(int i = 0; i < (n % s.length()); i++) {
			if(charArr[i] == 'a')
				finalCountOfAs++;
		}
		System.out.println(finalCountOfAs);
	}

}
