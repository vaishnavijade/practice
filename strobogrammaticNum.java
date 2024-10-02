/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, return all strobogrammatic numbers that are of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
line-1: Return a list of all strobogrammatic numbers of length n. The list can be in any order.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11, 69, 88, 96]

Explanation:
-------------
All valid strobogrammatic numbers of length 2 are:
11: Rotates to 11
69: Rotates to 96
88: Rotates to 88
96: Rotates to 69

Sample Input-2:
---------------
1

Sample Output-2: 
----------------
[0, 1, 8]

Explanation:
------------
The strobogrammatic numbers of length 1 are:
0: Rotates to 0
1: Rotates to 1
8: Rotates to 8

NOTE: Print the results in sorted order to pass the testcases */
import java.util.*;

public class strobogrammaticNum 
    {
    public static List<String> findStrobogrammatic(int n) {
        return generateStrobogrammatic(n, n);
    }

    private static List<String> generateStrobogrammatic(int n, int m) {
        if (n == 0) {
            return Arrays.asList(""); // Base case: empty string
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8"); // Base case: single-digit strobogrammatic numbers
        }

        List<String> result = new ArrayList<>();
        List<String> inner = generateStrobogrammatic(n - 2, m);

        for (String s : inner) {
            if (n != m) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        List<String> result = findStrobogrammatic(n);
        Collections.sort(result);
        System.out.println(result);

        
    }
}
/*import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> l=strobogrammatic(n);
        Collections.sort(l);
        System.out.println(l);
    }
    static char[][] digitPair={{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public static List<String> helper(int n,int m){
        if(n==0){
            return Arrays.asList("");
        }
        if(n==1){
            return Arrays.asList("0","1","8");
        }
        List<String> list=helper(n-2,m);
        ArrayList<String> al=new ArrayList<String>();
        for(int i=0;i<list.size();i++){
            String str=list.get(i);
            if(n!=m){
                al.add("0"+str+"0");
            }
            for(char[] adigitpair:digitPair){
                al.add(adigitpair[0]+str+adigitpair[1]);
            }
        }
        return al;
    }
    public static List<String> strobogrammatic(int n){
        int m=n;
        return helper(n,m);
    } 
}*/