
package practise;

import java.util.ArrayList;
import java.util.Scanner;


public class TCS_MaxPrize {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrSize = scan.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i=0; i<arrSize; i++) {
			arrayList.add(scan.nextInt());
		}
		
		int maxSum = 0;
		
		while(arrayList.size() > 1) {
			int neighbourIdx = maxNeighbourOfLargestNum(arrayList);
			if(neighbourIdx == 0) {
				maxSum += arrayList.get(0) * arrayList.get(1); 
			} else if(neighbourIdx == arrayList.size() - 1) {
				maxSum += arrayList.get(neighbourIdx) * arrayList.get(neighbourIdx - 1); 
			} else {
				if(arrayList.get(neighbourIdx - 1) > arrayList.get(neighbourIdx + 1))
					maxSum += arrayList.get(neighbourIdx) * arrayList.get(neighbourIdx - 1) + arrayList.get(neighbourIdx + 1);
				else
					maxSum += arrayList.get(neighbourIdx) * arrayList.get(neighbourIdx + 1) + arrayList.get(neighbourIdx - 1);
			}
			arrayList.remove(neighbourIdx);
		}
		
		maxSum += arrayList.get(0);
		System.out.println(maxSum);
	}

	private static int maxNeighbourOfLargestNum(ArrayList<Integer> arrayList) {
		int maxIdx = 0;
		for(int i=0; i<arrayList.size(); i++) {
			if(arrayList.get(i) > arrayList.get(maxIdx))
				maxIdx = i;
		}
		if(maxIdx == 0)
			return 1;
		else if(maxIdx == arrayList.size() - 1)
			return arrayList.size() - 2;
		else {
			if(arrayList.get(maxIdx - 1) > arrayList.get(maxIdx + 1))
				return maxIdx - 1;
			else
				return maxIdx + 1;
		}
	}
}
