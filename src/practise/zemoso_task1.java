package practise;

public class zemoso_task1 {
	public static void main(String[] args) {
		/*
		 * String S = "Sat"; int K = 23; K = K % 7; String[] days = {"Mon", "Tue",
		 * "Wed", "Thu", "Fri", "Sat", "Sun"}; int res = -1; for(int i=0; i<days.length;
		 * i++) { if(days[i].equals(S)) res = i + K; } res = res % 7;
		 * System.out.println(days[res]);
		 */
		
		int N = 56245;
		String number = Integer.toString(N);
		int[] digits = new int[number.length()];
		String finalNum = "";
		for(int i= 0 ; i<number.length(); i++) {
			digits[i] = number.charAt(i) - '0';
		}
		for(int i=0; i<digits.length; i++) {
			if(digits[i] < 5) {
				if(i == 0)
					finalNum = '5' + number;
				else
				finalNum = number.substring(0, i-1) + '5' + number.substring(i-1, number.length());
			}
		}
		System.out.println(finalNum);
	}
}
