package practise;

import java.util.Arrays;

public class SCALER_MinimizeDifference {

	public static void main(String args[]) {
		int[] arr = {2,3,6,8,9,1,3,5,6,7,8,7,9,3};
		int B = 4;
		Arrays.sort(arr);
		int len = arr.length;
		int minDiff = arr[len - 1] - arr[0];
		int maxCount = getCount(arr, true);
		int minCount = getCount(arr, false), count;
		
		while(B>0) {
			if(minCount>maxCount) {
				arr[len - 1]--;
				for(int i=arr.length-1; i>0; i--) {
					if(arr[i] < arr[i-1]) 
						swap(arr, i, i-1);
					else break;
				}
				maxCount = getCount(arr, true);
			}
			else {
				arr[0]++;
				for(int i=0; i<arr.length-1; i++) {
					if(arr[i] > arr[i+1]) 
						swap(arr, i, i+1);
					else break;
				}
				minCount = getCount(arr, false);
			}
			int diff = arr[len - 1] - arr[0];
			minDiff = Math.min(diff, minDiff);
			B--;
		}
		System.out.println(minDiff);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int getCount(int[] arr, boolean isMax) {
		int count = 1;
		if(isMax) {
			for(int i=arr.length-2; i>0; i--) {
				if(arr[arr.length-1] == arr[i]) 
					count++;
				else break;
			}
		} else {
			for(int i=1; i<arr.length-1; i++) {
				if(arr[0] == arr[i]) 
					count++;
				else break;
			}
		}
		return count;
	}
}
