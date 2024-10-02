import java.util.*;
public class climbingStairs{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=stairs(n);
        System.out.println(res);
    }
    public static int stairs(int n){
        if(n==1)return 1;
        else if (n==2) return 2;
        return stairs(n-1)+stairs(n-2);
    }
}
/*

if no.of stairs one can step at once is more or less than 2 import java.util.*; 
class Stairs_M2 
{ 

 static int countWaysUtil(int n, int m) 
 { 
  if (n <= 2) 
   return n; 
  int res = 0; 
  for (int i = 1; i <= m && i <= n; i++) 
   res += countWaysUtil(n - i, m); 
  return res; 
 } 
 
 // Returns number of ways to reach s'th stair 
 static int countWays(int s, int m) 
 { 
  return countWaysUtil(s , m); 
 } 
 
  
 public static void main(String args[]) 
 { 
  Scanner sc =new Scanner(System.in); 
  System.out.println("enter total no.of stairs"); 
  int s = sc.nextInt(); 
System.out.println("enter possible stairs "); 
int m = sc.nextInt(); 
  System.out.println("Number of ways = " 
      + countWays(s, m)); 
 } 
}



import java.util.*;

public class climbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of stairs
        List<Integer> currentSteps = new ArrayList<>();  // List to store current step sequence
        System.out.println("Total ways: " + stairs(n, currentSteps));
    }

    // Function to print all combinations and return the count of ways
    public static int stairs(int n, List<Integer> currentSteps) {
        if (n == 0) { // If we have exactly reached the top, print the current sequence
            System.out.println(currentSteps);
            return 1;
        } else if (n < 0) { // If the steps exceeded, return 0
            return 0;
        }

        // Variable to count the number of valid ways
        int totalWays = 0;

        // Take 1 step
        currentSteps.add(1);
        totalWays += stairs(n - 1, currentSteps);  // Recurse with one step
        currentSteps.remove(currentSteps.size() - 1);  // Backtrack to try the next possibility

        // Take 2 steps
        currentSteps.add(2);
        totalWays += stairs(n - 2, currentSteps);  // Recurse with two steps
        currentSteps.remove(currentSteps.size() - 1);  // Backtrack

        return totalWays;  // Return the total number of ways
    }
}


You are climbing a staircase. It takes n steps to reach the top. 
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

Constraints:
------------
1 ≤ n ≤ 45
Each time you can take either 1 step or 2 steps.
You need to compute the total number of distinct ways to climb the staircase.

Input Format:
--------------
Line-1: A single integer n, representing the number of steps required to reach the top.

Output Format:
---------------
Line-1: A single integer representing the number of distinct ways to climb to the top.

Sample Input-1: 
----------------
2

Sample Output-1: 
----------------
2

Explanation: There are two ways to climb to the top:
1 step + 1 step
2 steps

Sample Input-2: 
---------------
3

Sample Output-2: 
----------------
3

Explanation: There are three ways to climb to the top:
1 step + 1 step + 1 step
1 step + 2 steps
2 steps + 1 step
 */

 /*import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
        System.out.println(fibonacci(i)+"");}
    }
    public static int fibonacci(int n){
        if(n==0)return 0;
        else if (n==1||n==2) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
} */


/*import java.util.*;
import java.math.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger res=factorial(BigInteger.valueOf(n));
        System.out.println(res);
    }
    public static BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.ZERO ))return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
} */