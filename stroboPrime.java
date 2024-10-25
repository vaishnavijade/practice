
import java.util.*;
class stroboPrime{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        String s=Integer.toString(m);
        int n=s.length();
        List<String> l=strobogrammatic(n);
        Collections.sort(l);
        boolean isStrob=false;
        for(String i:l){
            if(i.equals(s)){
                isStrob=true;
            }
        }
        System.out.print(isStrob+" ");
        System.out.print(isPrime(m));
    }
    public static boolean isPrime(int n){
        boolean isPrimeStrob=true;
        if (n<=1){
            isPrimeStrob=false;
        }
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                isPrimeStrob=false;
            }
        }
        return isPrimeStrob;
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
}
/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, check is n is strobogrammatic number and prime strobogrammatic number.

Input Format:
-------------
Line-1: A single integer n.

Output Format:
--------------
Line-1: Space separated two boolean values, represents "is strobogrammatic number" and "is prime strobogrammatic number".

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
1001

Sample Output-1: 
----------------
true false


Sample Input-2:
---------------
101

Sample Output-2: 
----------------
true true

Sample Input-3:
---------------
9999

Sample Output-3: 
----------------
false false
 */