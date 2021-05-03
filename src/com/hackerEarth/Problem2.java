package com.hackerEarth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
	private static String yes = "YES";
	private static String no = "NO";

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++)
			list.add(BigInteger.valueOf(Long.valueOf(scan.next())));
		scan.close();

		for (BigInteger num : list) {
			int count = 0;
			if (BigInteger.valueOf(4) == num) {
				System.out.println(yes);
			} else if (num.mod(BigInteger.valueOf(2)) == BigInteger.ZERO) {
				System.out.println(no);
			} else {

				for (BigInteger i = BigInteger.valueOf(3); i.compareTo(num) == -1; i=i.add(BigInteger.valueOf(2))) {
					if (num.mod(i) == BigInteger.ZERO)
						count++;
					if (count > 1)
						break;
				}
				if (count == 1)
					System.out.println(yes);
				else
					System.out.println(no);
			}
		}
	}
}
/*
T-Primes

We know that prime numbers are positive integers that have exactly two distinct positive divisors.
Similarly, we'll call a positive integer t Т-prime, if t has exactly three distinct positive divisors. 
You are given an array of n positive integers. For each of them determine whether it is Т-prime or not.

Input:
The first line contains a single positive integer, n (1 ≤ n ≤ 105), showing how many numbers are in the array. 
The next line contains n space-separated integers xi (1 ≤ xi ≤ 1012). 
Please, do not use the %lld specifier to read or write 64-bit integers in С++. 
It is advised to use the cin, cout streams or the %I64d specifier.

Output:
Print n lines: the i-th line should contain "YES" (without the quotes), 
if number xi is Т-prime, and "NO" (without the quotes), if it isn't.



*/
