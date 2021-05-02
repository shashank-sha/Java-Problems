package practise;

public class HR_JumpingOnTheClouds {
	
	public static void main(String args[]) {
		int[] c = {0,0,1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,0};
		int noOfJumps = 0;
		for(int i=0; i<c.length; i++) {
			if(i+2 < c.length && c[i+2] == 0)
				i++;
			noOfJumps++;
		}
		noOfJumps--;
		System.out.println(noOfJumps);
	}

}
