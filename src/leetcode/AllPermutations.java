package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
	
	
	public static void main(String[] args) {
		Set<String> permutationSet = new HashSet<String>();
		String s = "()";
		printAllPermutations(s, "", permutationSet);
		
		for(String s1: permutationSet) {
			System.out.println(s1);
		}
		System.out.println(permutationSet.size());
		new ArrayList<String>(permutationSet);
	}

	private static void printAllPermutations(String s, String s1, Set<String> permutationSet) {
		if(s.isEmpty())
			permutationSet.add(s1);
			
		int len = s.length();
		for(int i=0; i<len; i++) {
			if(isValid(s1+s.charAt(i)))
			printAllPermutations(s.substring(0, i) + s.substring(i+1, len), s1+s.charAt(i), permutationSet);
		}
		
	}

	private static boolean isValid(String str) {
		int counter = 0;
		for(char c: str.toCharArray()) {
			if(c == '(')
				counter++;
			else
				counter--;
			if(counter < 0)
				return false;
		}
		return true;
	}
}
