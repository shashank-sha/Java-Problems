package practise;

public class HR_MinimumSwaps2 {

	public static void main(String[] args) {
		int[] arr = {1,3,5,2,4,6,7};
		int noOfSwaps = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != (i+1)) {
				int idx = find(arr, i+1);
				swap(arr, i, idx);
				noOfSwaps++;
			}
		}
		System.out.println(noOfSwaps);
	}

	private static void swap(int[] arr, int i, int idx) {
		int temp = arr[i];
		arr[i] = arr[idx];
		arr[idx] = temp;
	}

	private static int find(int[] arr, int ele) {
		for(int i = ele-1; i < arr.length; i++) {
			if(arr[i] == ele)
				return i;
		}
		return -1;
	}

}
