package practise;

import java.util.Scanner;

public class TCS_PasteReduction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String para = scan.nextLine();
		String fKeys = scan.nextLine();
		StringBuilder pasteStrBuilder = new StringBuilder();
		int noOps = 0;

		for (char c : para.toCharArray()) {
			if (fKeys.contains(String.valueOf(c))) {
				pasteStrBuilder.append(c);
			}
		}

		while (true) { // Removes exact occurrences
			int idx = pasteStrBuilder.toString().indexOf(fKeys);
			if (idx != -1) {
				pasteStrBuilder.delete(idx, idx + fKeys.length());
				noOps++;
			} else {
				break;
			}
		}

		for (int i = 0; i < fKeys.length(); i++) {
			int j = 0, k = i;
			while (true) {
				if (fKeys.charAt(i) == pasteStrBuilder.charAt(j)) {
					pasteStrBuilder.deleteCharAt(j);
					i++;
				}
				if (j == pasteStrBuilder.length()-1 && i != k) {
					noOps++;
					i = k;
					j = 0;
				} else if (j == pasteStrBuilder.length()-1 && i == k) {
					break;
				} else if(pasteStrBuilder.length() == 0) {
					noOps++;
					break;
				}
				j++;
			}
		}
		System.out.println(noOps);
	}

}
