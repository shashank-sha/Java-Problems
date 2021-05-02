package practise;

public class HR_ArraysLeftRotation {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int d = 2, j = 0;
		int[] outputArr = new int[a.length];
		for(int i = d; i < a.length; i++) {
			outputArr[j] = a[i];
		}
		
		for(int i = 0; i < d; i++) {
			outputArr[j] = a[i];
		}
		System.out.println(outputArr);
	}

}
