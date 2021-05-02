package com.skillenza;

import java.util.HashMap;
import java.util.Scanner;

public class TreesInAForest {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n > 0) {
			int len = scan.nextInt();
			String s = scan.next();
			int counter = 0;
			int noOfBinaryTrees = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			boolean isBinaryTree = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '[') {
					counter++;
					map.put(counter, 0);
				} else {
					map.remove(counter);
					counter--;
					if (counter == 0) {
						if (isBinaryTree)
							noOfBinaryTrees++;
						counter = 0;
						isBinaryTree = true;
					} else {
						int count = map.get(counter);
						if (count == 2)
							isBinaryTree = false;
						map.put(counter, ++count);
					}
				}
			}
			System.out.println(noOfBinaryTrees);
			n--;
		}
		scan.close();
	}
}

/*

Trees in a Forest
You’re given a balanced bracket expression. 
A balanced bracket expression can be represented as a forest. 
From among the disjoint set of trees which the forest is comprised of, 
find the ones which are binary trees and output the count. 
A binary tree is a tree data structure in which each vertex has at most two children.

Input Format
First line of input consists of an integer t denoting the number of test cases. 
First line of each test case consists of an integer n denoting the length of the expression. 
Second line consists of the bracket expression.

Output Format
For each bracket expression output the number of binary trees in separate lines.

Constraints
1 <= t <= 10000

n = 2 * m where 1 <= m <= 1000

Sample Input
4
16
[[[][]][][[]][]]
18
[[][][]][[][[][]]]
20
[[[]]][[[[[[[]]]]]]]
24
[][[]][[[][]]][[][][][]]
Sample Output
0
1
2
3
Explanation
For test case 1

The expression [[[][]][][[]][]] has the following tree representation.

[]
├── []
│   ├── []
│   └── []
├── []
├── []
│   └── []
└── []
The forest is comprised of 1 tree.

The number of binary trees is 0.

For test case 2

The expression [[][][]][[][[][]]] has the following tree representation.

[]
├── []
├── []
└── []
[]
├── []
└── []
    ├── []
    └── []
The forest is comprised of 2 trees.

The number of binary trees is 1.

For test case 3

The expression [[[]]][[[[[[[]]]]]]] has the following tree representation.

[]
└── []
    └── []
[]
└── []
    └── []
        └── []
            └── []
                └── []
                    └── []
The forest is comprised of 2 trees.

The number of binary trees is 2.

For test case 4

The expression [][[]][[[][]]][[][][][]] has the following tree representation.

[]
[]
└── []
[]
└── []
    ├── []
    └── []
[]
├── []
├── []
├── []
└── []
The forest is comprised of 4 trees.

The number of binary trees is 3.

*/