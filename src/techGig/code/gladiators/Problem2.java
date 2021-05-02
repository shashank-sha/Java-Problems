package techGig.code.gladiators;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Problem2 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		HashMap<Integer, List<Integer>> inputs = new HashMap<>();
		HashMap<Integer, Integer> outputs = new HashMap<>();
		while (i < n) {
			int l = scan.nextInt();
			int r = scan.nextInt();
			List<Integer> pair = new ArrayList<>();
			pair.add(l);
			pair.add(r);
			inputs.put(i, pair);
			i++;
		}
		scan.close();

		ExecutorService executorService = Executors.newFixedThreadPool(n);
		for (i = 0; i < n; i++) {
			List<Integer> pair = inputs.get(i);
			final int idx = i;
			Runnable task = () -> {
				List<Integer> primes = findPrimes(pair.get(0), pair.get(1));
				if (primes.size() == 0)
					outputs.put(idx, -1);
				else if (primes.size() == 1)
					outputs.put(idx, 0);
				else {
					int size = primes.size();
					int res = primes.get(size - 1) - primes.get(0);
					outputs.put(idx, res);
				}
			};
			executorService.execute(task);
		}
		executorService.shutdown();

		while (!executorService.isTerminated()) {
		}

		for (i = 0; i < n; i++) {
			System.out.println(outputs.get(i));
		}
	}

	private static List<Integer> findPrimes(int l, int r) {
		List<Integer> primes = new ArrayList<>();
		if (l == 2)
			primes.add(2);
		if (l % 2 == 0)
			l++;
		int lowLimit = -1;

		// To find least prime number
		for (int i = l; i <= r; i = i + 2) {
			int counter = 0;
			for (int num = i; num >= 1; num = num - 2) {
				if (i % num == 0)
					counter++;
				if (counter == 3)
					break;
			}
			if (counter == 2) {
				primes.add(i);
				lowLimit = i;
				break;
			}
		}

		// To find largest prime number
		if (lowLimit != -1) {
			if (r % 2 == 0)
				r--;
			for (int i = r; i >= lowLimit; i = i - 2) {
				int counter = 0;
				for (int num = i; num >= 1; num = num - 2) {
					if (i % num == 0)
						counter++;
					if (counter == 3)
						break;
				}
				if (counter == 2) {
					primes.add(i);
					break;
				}
			}
		}
		return primes;
	}
}

/*
 * 
 * Prime Game (100 Marks) Rax, a school student, was bored at home in the
 * pandemic. He wanted to play but there was no one to play with. He was doing
 * some mathematics questions including prime numbers and thought of creating a
 * game using the same. After a few days of work, he was ready with his game. He
 * wants to play the game with you.
 * 
 * 
 * GAME:
 * 
 * Rax will randomly provide you a range [ L , R ] (both inclusive) and you have
 * to tell him the maximum difference between the prime numbers in the given
 * range. There are three answers possible for the given range.
 * 
 * There are two distinct prime numbers in the given range so the maximum
 * difference can be found.
 * 
 * There is only one distinct prime number in the given range. The maximum
 * difference in this case would be 0.
 * 
 * There are no prime numbers in the given range. The output for this case would
 * be -1.
 * 
 * 
 * To win the game, the participant should answer the prime difference correctly
 * for the given range.
 * 
 * 
 * Example:
 * 
 * Range: [ 1, 10 ]
 * 
 * The maximum difference between the prime numbers in the given range is 5.
 * 
 * Difference = 7 - 2 = 5
 * 
 * 
 * Range: [ 5, 5 ]
 * 
 * There is only one distinct prime number so the maximum difference would be 0.
 * 
 * 
 * Range: [ 8 , 10 ]
 * 
 * There is no prime number in the given range so the output for the given range
 * would be -1.
 * 
 * 
 * Can you win the game?
 * 
 * 
 * 
 * Input Format The first line of input consists of the number of test cases, T
 * 
 * Next T lines each consists of two space-separated integers, L and R
 * 
 * 
 * 
 * Constraints 1<= T <=10
 * 
 * 2<= L<= R<=10^6
 * 
 * 
 * 
 * Output Format For each test case, print the maximum difference in the given
 * range in a separate line.
 * 
 * Sample TestCase 1 Input 5 5 5 2 7 8 10 10 20 4 5 Output 0 5 -1 8 0
 * Explanation
 * 
 * Test Case 1: [ 5 - 2 ] = 3
 * 
 * Test Case 2: [ 7 - 2 ] = 5
 * 
 * Test Case 3: No prime number in the given range. Output = -1
 * 
 * Test Case 4: [ 19 - 11 ] = 8
 * 
 * Test Case 5: The difference would be 0 since there is only one prime number
 * in the given range.
 * 
 */