package practise;

public class SCALAR_ChangeCharacter {

	static final int MAX_CHAR = 256;
	public static void main(String[] args) {
		String A = "aabaabcddf";
		int B = 3;
		int count[] = new int[MAX_CHAR];
		int noOfDistinctChar = 0;
		
		for(int i=0; i<A.length(); i++) {
			count[A.charAt(i)]++;
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i] > 0)
				noOfDistinctChar++;
		}
		
		while(B>0) {
			B = B - getMinCount(count, A);
			noOfDistinctChar--;
		}
		if(B<0)
			noOfDistinctChar++;
		System.out.println(noOfDistinctChar);
	}
	
	public static int getMinCount(int[] arr, String A) {
		int min = Integer.MAX_VALUE;
		char minChar = ' ';
		for(int i=0; i<A.length(); i++) {
			int count = arr[A.charAt(i)];
			if(count > 0 && min > count) {
				min = arr[A.charAt(i)];
				minChar = A.charAt(i);
			}
		}
		arr[minChar] = 0;
		return min;
	}

}
