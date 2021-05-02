package practise;
public class PalindromeSubstring {
   private static int countPalindromeSubstring(String str){
       String temp = "";
       int count = 0;
       for (int i = 0; i < str.length(); i++) {
           for (int j = i + 1; j <= str.length(); j++) {
               temp = str.substring(i, j);               
               // If length is greater than or equal to two check for palindrome    
               if (temp.length() >= 2) {
                   if(isPlaindrome(temp))
                	   count++;
               }
           }
       }
       // Adding str length as individual characters are self palindromes 
       count = count + str.length();
       return count;
   }

private static boolean isPlaindrome(String temp) {
	StringBuffer strBuffer;
	strBuffer = new StringBuffer(temp);
	strBuffer.reverse();
	if (strBuffer.toString().compareTo(temp) == 0)
		return true;
	else
		return false;
}

     

   // Driver Code

   public static void main(String args[]) throws Exception {

       // Declare and initialize the string

       String str = "7652+";

       // Call the method

       System.out.println(countPalindromeSubstring(str));

   }

}