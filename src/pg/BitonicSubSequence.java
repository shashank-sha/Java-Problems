/*Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.

Examples:

Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
Input arr[] = {12, 11, 40, 5, 3, 1}
Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
Input arr[] = {80, 60, 30, 40, 20, 10}
Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)*/

package pg;

public class BitonicSubSequence {

	public static void main(String[] args) {
		int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		
		int count = 0;
		int p = 0;
		for(int i = 1; i<arr.length; i++) {
			if(arr[p] < arr[i]) {
				p = i;
				count++;
			}
		}
		//decrese order
		for(int i = p+1; i<arr.length; i++) {
			if(arr[p] > arr[i]) {
				p = i;
				count++;
			}
		}
		
		count++;
		System.out.println(count);
	}
	
	private static int getIncreaseOrderLen(int[] arr) {
		// TODO Auto-generated method stub
		int count = 1;
		int p = 0;
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[p] < arr[i]) {
				p = i;
				count++;
			}
		}
		return count;
	}

	private static int getDecreaseOrderLen(int[] arr) {
		// TODO Auto-generated method stub
		int count = 1;
		int p = 0;
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[p] > arr[i]) {
				p = i;
				count++;
			}
		}
		return count;
	}
}
