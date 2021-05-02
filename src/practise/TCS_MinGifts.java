package practise;

import java.util.ArrayList;
import java.util.Scanner;

public class TCS_MinGifts {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		while(testCases > 0) {
			int arrSize = scan.nextInt();
			int[] arrayList = new int[arrSize];
			int[] sumList = new int[arrSize];
			for(int i=0; i<arrSize; i++) {
				arrayList[i] = scan.nextInt();
				sumList[i] = 0;
			}
			
			for(int i=0; i<arrSize; i++) {
				int idx = getSmallestNum(arrayList);
				if(idx == 0) {
					if(arrayList[idx+1] < arrayList[idx])
						sumList[idx] = sumList[idx+1]++;
					else
						sumList[idx]++;
				} else if(idx == arrSize - 1) {
					if(arrayList[idx-1] < arrayList[idx])
						sumList[idx] = sumList[idx-1]++;
					else
						sumList[idx]++;
				}
			}
			
			testCases--;
		}
	}
	
	private static int getSmallestNum(int[] arrayList) {
		int minIdx = 0;
		for(int i=0; i<arrayList.length; i++) {
			if(arrayList[i] < arrayList[minIdx])
				minIdx = i;
		}
		return minIdx;
	}
}
