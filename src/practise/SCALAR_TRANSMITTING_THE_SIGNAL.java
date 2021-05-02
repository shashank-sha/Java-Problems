package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SCALAR_TRANSMITTING_THE_SIGNAL {
	public static void main(String args[]) {
		System.out.println(solve(1, 1, new int[] {0,2,3},new int[] {0,2,1}));
	}
	public static int[] solve(int A, int B, int[] C, int[] D) {
		int[] result = new int[C.length];
		TreeMap<Double, ArrayList<Integer>> resultMap = new TreeMap<Double, ArrayList<Integer>>();
		double res;
		for(int i=0; i<C.length; i++) {
			res = Math.pow(A-C[i], 2) + Math.pow(B-D[i], 2);
			if(resultMap.containsKey(res)) {
				ArrayList<Integer> arr = resultMap.get(res);
				arr.add(i);
				resultMap.put(res, arr);
			}
			else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i);
				resultMap.put(res, arr);
			}
		}
		int i = 0;
		for(Map.Entry m: resultMap.entrySet()) {
			ArrayList<Integer> arr = (ArrayList<Integer>) m.getValue();
			if(arr.size() == 1)
				result[i++] = arr.get(0)+1;
			else {
				if(C[arr.get(0)] >= C[arr.get(1)]) {
					result[i++] = arr.get(0)+1;
					result[i++] = arr.get(1)+1;
				}
				else {
					result[i++] = arr.get(1)+1;
					result[i++] = arr.get(0)+1;
				}
			}
		}
		
		return result;
    }
}
