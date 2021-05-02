package practise;

public class HR_NewYearChaos {

	public static void main(String[] args) {
		int[] q = {2,1,5,3,4};
		int noOfBribes = 0;
		for(int i = q.length - 1; i >= 0; i--) {
			if(q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for(int j = Integer.max(0, q[i] - 2); j < i; j++)
				if(q[j] > q[i]) noOfBribes++;
		}
		System.out.println(noOfBribes);
	}

}
