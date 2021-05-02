package practise;

public class xor {
	
	public static void main(String args[]) {
		int A = 4967546, B = 22;
		char[] binaryA = Integer.toBinaryString(A).toCharArray();
		StringBuilder binaryB = new StringBuilder();
		
		//sets corresponding 1's in A to B
		for(int i = 0; i < binaryA.length && B > 0; i++) {
			if(binaryA[i] == '1') {
				binaryB.append('1');
				B--;
			} else
				binaryB.append('0');
		}
		System.out.println(binaryA);
		System.out.println(binaryB);
		
		//sets the last bits to 0
		if(binaryB.length() < binaryA.length) {
			int diff = binaryA.length - binaryB.length();
			for(int i = 0; i < diff; i++) {
				binaryB.append('0');
			}
		}
		System.out.println(binaryB);
		
		//Sets bits with 0 from right if B>0
		if(B > 0) {
			for(int i = binaryB.length() - 1; i >= 0 && B > 0; i--) {
				if(binaryB.charAt(i) == '0') {
					binaryB.setCharAt(i, '1');
					B--;
				}
			}
		}
		System.out.println(binaryB);
		//Appends more 1 if B>0 which means number of bits in A is less than B
		if(B > 0) {
			for(int i = 0; i < B; i++) {
				binaryB.append('1');
			}
		}
		System.out.println(binaryB);
		
		System.out.println(Integer.parseInt(binaryB.toString(), 2));
	}

}
