package practise;

public class HR_2DArrayDS {

	public static void main(String[] args) {
		int[][] arr = {{1,1,1,0,0,0},
						{0,1,0,0,0,0},
						{1,1,1,0,0,0},
						{0,0,2,4,4,0},
						{0,0,0,2,0,0},
						{0,0,1,2,4,0}};
		int maxHourGlassSum = Integer.MIN_VALUE;
		int hourGlassSum = 0;
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 3; j++) {
				hourGlassSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]
									+ arr[i+2][j+0] + arr[i+2][j+1] + arr[i+2][j+2];
				maxHourGlassSum = Integer.max(maxHourGlassSum, hourGlassSum);
			}
		}
		System.out.println(maxHourGlassSum);
	}

}
