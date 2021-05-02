package practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HR_SockMerchant {

	public static void main(String[] args) {
		int[] ar = {1,2,3,2,2,3,5};
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for(int i=0; i<ar.length; i++) {
			if(hm.containsKey(ar[i]))
				hm.put(ar[i], hm.get(ar[i]) + 1);
			else
				hm.put(ar[i], 1);
		}
		Iterator hmIterator = hm.entrySet().iterator();
		int pairs = 0;
		while(hmIterator.hasNext()) {
			Map.Entry<Integer, Integer> hmElement = (Map.Entry<Integer, Integer>)hmIterator.next();
			pairs = pairs + hmElement.getValue() / 2;
		}
		System.out.println(pairs);
	}

}
