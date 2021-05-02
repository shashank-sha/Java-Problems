package practise;

public class zemosoo {
	public static void main(String[] args) {
		System.out.println(solution(8, 0));
	}
	
	public static int solution(int N, int K) {
		if(K == 0) {
			return N-1;
		}else {
			int rounds = 0;
			while(N > 1) {
				if(N%2 == 0 && K > 0) {
					N = N/2;
					K--;
				}else{
				    N--;
				}
				rounds++;
			}
			return rounds;
		}
    }
}
