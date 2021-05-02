package practise;

import java.io.*;
import java.util.*;

public class NewTest
{
	public static void findparents(String S,int n,String[] strarr) {
	
		int stringNumber1=0,stringNumber2=0;
		String subString1 = null,subString2 = null;
		subString1 = S.substring(0, S.length()/2);
		subString2 = S.substring(S.length()/2, S.length());
		
		boolean status = findparents(strarr, stringNumber1, stringNumber2, subString1, subString2);
		if(!status && S.length()%2 != 0) {	//Checking for the another possibility for an odd length String
			subString1 = S.substring(0, S.length()/2 + 1);
			subString2 = S.substring(S.length()/2 + 1, S.length());
			if(!findparents(strarr, stringNumber1, stringNumber2, subString1, subString2))
				System.out.print(stringNumber1+" "+stringNumber2);
			
		} else if(!status)
			System.out.print(stringNumber1+" "+stringNumber2);
	}

	private static boolean findparents(String[] strarr, int stringNumber1, int stringNumber2, String subString1,
			String subString2) {
		for(int i=0; i<strarr.length; i++) {
			int index_p1 = strarr[i].indexOf(subString1);
			int index_p2 = strarr[i].indexOf(subString2);
			if(index_p1 != -1)
				stringNumber1 = i+1;
			if(index_p2 != -1)
				stringNumber2 = i+1;
		}
		if(stringNumber1 != 0 && stringNumber2 != 0 ) {
			System.out.print(stringNumber1+" "+stringNumber2);
			return true;
		}else
			return false;
	}
	
   public static void main(String args[])
   {
	   Scanner sc=new Scanner(System.in);
	
	//INPUT [uncomment & modify if required]	   
	   String S=new String("");
	   S=sc.nextLine();
	   
	   int n;
	   n=sc.nextInt();
	   
	   String[] arr=new String[n];
	   
	   sc.nextLine();
	   
	   for(int i=0;i<n;i++) {
		   arr[i]=sc.nextLine();
	   }
	  
	   
	   sc.close();
	//OUTPUT [uncomment & modify if required]
	   findparents(S,n,arr);
   }
   
}