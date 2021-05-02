package techGig.code.gladiators;

import java.io.*;
import java.util.*;
public class Problem1 {
    public static void main(String args[] ) throws Exception {

    	Scanner scan = new Scanner(System.in);
        String V = scan.next();
        int N = scan.nextInt();
        ArrayList<String> BiList = new ArrayList<>();
        for(int i=0; i<N; i++){
            BiList.add(scan.next());
        }
        scan.close();

        int VLen = V.length();
        HashMap<Character, ArrayList<Integer>> map =
            new HashMap<>();
        for(int i=0; i<VLen; i++){
            ArrayList<Integer> list = null;
            if(map.containsKey(V.charAt(i))){
                list = map.get(V.charAt(i));
            }else{
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(V.charAt(i), list);
        }

        for(String Bi: BiList){
            int BiLen = Bi.length();
            int prev = -1;
            boolean isPositive = true;
            for(int i=0; i<BiLen; i++){
                char c = Bi.charAt(i);
                if(map.containsKey(c)){
                    ArrayList<Integer> list = map.get(c);
                    if(list.size() == 1 && list.get(0) > prev){
                        prev = list.get(0);
                    } else{
                        boolean nextExists = false;
                        for(int j:list){
                            if(j > prev){
                                prev = j;
                                nextExists = true;
                                break;
                            }
                        }
                        if(!nextExists){
                            isPositive = false;
                            break;
                        }
                    }
                }else{
                    isPositive = false;
                    break;
                }
            }
            if(isPositive)
                System.out.println("POSITIVE");
            else
                System.out.println("NEGATIVE");
        }
   }
}

/*
c - [0]
o - [1,3]
r - [2,8]
n - [4]
a - [5]
v - [6]
i - [7]
u - [9]
s - [10]
*/

/* Problem Statement:

Virus Outbreak (100 Marks)
In the Martian land faraway, a new virus has evolved and is attacking the individuals at a fast pace. 
The scientists have figured out the virus composition, V. The big task is to identify the people who are infected. 
The sample of N people is taken to check if they are POSITIVE or NEGATIVE. 
A report is generated which provides the current blood composition B of the person. 


POSITIVE or NEGATIVE ?

If the blood composition of the person is a subsequence of the virus composition V, 
then the person is identified as POSITIVE otherwise NEGATIVE.


Example:

Virus Composition, V = coronavirus

Blood Composition of the person , B = ravus


The person in question is POSITIVE as B is the subsequence of the V. 

 

The scientists are busy with their research for medicine and request you to build 
a program which can quickly figure out if the person is POSITIVE or NEGATIVE. 
They will provide you with the virus composition V and all the people’s current blood composition. Can you help them?


Note: The virus and blood compositions are lowercase alphabet strings.

Input Format
The first line of the input consists of the virus composition, V

The second line of he input consists of the number of people, N

Next N lines each consist of the blood composition of the ith person, Bi




Constraints
1<= N <=10

1<= |B|<= |V|<= 10^5



Output Format
For each person, print POSITIVE or NEGATIVE in a separate line

Sample TestCase 1

Input:
coronavirus
3
abcde
crnas
onarous

Output:
NEGATIVE
POSITIVE
NEGATIVE
*/