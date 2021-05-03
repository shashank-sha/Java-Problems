package com.hackerEarth;

import java.util.ArrayList;
import java.util.Scanner;
public class Problem1 {
    public static void main(String args[] ) throws Exception {
      
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = scan.nextInt();
        for(int i=0; i<n ;i++)
        	list.add(scan.nextInt());
        int nDigits = scan.nextInt();
        
        ArrayList<Integer> nums = getAllNDigitNums(list, nDigits);
        
    }

	private static ArrayList<Integer> getAllNDigitNums(ArrayList<Integer> list, int nDigits) {
		for(int i=0;i<list.size();i++) {
			
		}
		return null;
	}
}
/*

Digits and Divisibility:

You have been given a set of digits, 
where each digit in the set is distinct and lies in the range from 0 to 9 inclusive.
You are required to create a k-digit  number from the set of digits that is given to you. 
Each digit from the set can be used for an arbitrary number of times to create the number.
You must create the number based on the following rule:
	The number should be created in such a way that it should be divisible by 3

If there exist multiple such numbers, your task is to print the smallest k-digit number that can be created by using the digits that are available in the given set. 
In other words, you are required to determine the smallest k-digit  number that is divisible by 3  consisting of only the digits that are available in the set.

Note: : The number should be a valid number and should not consist of any leading zeros unless the answer is 0 itself.

Input:
4
0 4 6 8
2

Output:
48

Explanation:

The smallest 2  digit number that is divisible by 3  consisting only of the digits (0,4,6,8) is 48


*/
