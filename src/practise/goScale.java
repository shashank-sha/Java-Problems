package practise;

import java.util.ArrayList;
import java.util.Iterator;

public class goScale {
	public static void main(String[] args) {
	int[] arr = {74654,55812,57734,80295,95827,65072,45838,60883,74288,90423,68739,87389,17959,51731,10131,61002,46236,99905,22291,58610,16514,85844,38582,20664,85687,13907,96005,22315,94857,62527,95235,10593,12517,71470,72127,29060,43577,86142,29975,83557,90567,90429,80090,36247,49598,35243,48692,89173,87760,85705,15090,80418,34376,36545,66877,62426,91830,30423,64570,51238,44489,46465,69950,96826,85315,44260,32673,75459,14602,92998,73488,47911,78763,94014,82888,61274,94861,30344,10025,77992,68989,30645,87456,30781,79390,46198,44617,50498,98594,81131,76445,28645,30060,75529,95659,87509,11825,28998,67093,83455};
	int n = arr.length;
	
    for (int i = 0; i < (1<<n); i++){ 
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int j = 0; j < n; j++) {
            if ((i & (1 << j)) > 0) {
                arrayList.add(arr[j]);
            }
        }
        if(arrayList.size() > 1) {
        	System.out.println(arrayList);
        	System.out.println(checkUniquness(arrayList));
        }
        sum(arrayList);
    }
	}

	private static void sum(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		Iterator<Integer> itr = arrayList.iterator();
		while(itr.hasNext()) {
			itr.next();
		}
	}

	private static boolean checkUniquness(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		Iterator<Integer> itr = arrayList.iterator();
		String str = "";
		while(itr.hasNext()) {
			str += itr.next().toString();
		}
		int checker = 0; 
		  
        for (int i = 0; i < str.length(); i++) { 
            int bitAtIndex = str.charAt(i) - 'a'; 
            if ((checker & (1 << bitAtIndex)) > 0) 
                return false; 
            checker = checker | (1 << bitAtIndex); 
        } 
        return true; 
	}
}
