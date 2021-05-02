package practise;

import java.io.IOException;

public class HR_Arraymanipulation {

	public static void main(String[] args) throws IOException {
		  int n = 10;
		  long x = 0, max = 0;
		  int[][] queries = {{1,5,3}, {4,8,7}, {6,9,1}};
		  int[] arr = new int[n+1];
		  for(int i = 0; i < queries.length; i++) {
			  int a = queries[i][0];
			  int b = queries[i][1];
			  int sum = queries[i][2];
			  arr[a] = arr[a] + sum;
			  if((b+1) <= n) 
				  arr[b+1] = arr[b+1] - sum;
		  }
		  
		  for(int i = 1; i < arr.length; i++) {
			  x = x + arr[i];
			  max = Long.max(max, x);
		  }
		  
		  System.out.println(max);
	}
}
