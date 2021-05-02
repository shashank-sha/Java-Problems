package com.skillenza;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreesInAForest1 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		HashMap<Integer, Integer> output = new HashMap<>();
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
		for (int i = 0; i < n; i++) {
			int len = scan.nextInt();
			String s = scan.next();
			final int idx = i;
			Runnable task = () -> {
				output.put(idx, getNoOfBinaryTrees(s));
			};
			executorService.execute(task);
		}
		scan.close();
		executorService.shutdown();
		if (!executorService.isTerminated()) {
		}

		for (int i = 0; i < n; i++)
			System.out.println(output.get(i));
	}

	private static int getNoOfBinaryTrees(String s) {
		int counter = 0;
		int noOfBinaryTrees = 0;
		HashMap<String, Integer> map = new HashMap<>();
		boolean isBinaryTree = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				counter++;
				map.put("p" + counter, 0);
			} else {
				map.remove("p" + counter);
				counter--;
				if (counter == 0) {
					if (isBinaryTree)
						noOfBinaryTrees++;
					counter = 0;
					isBinaryTree = true;
				} else {
					int count = map.get("p" + counter);
					if (count == 2)
						isBinaryTree = false;
					map.put("p" + counter, ++count);
				}
			}
		}
		return noOfBinaryTrees;
	}
}