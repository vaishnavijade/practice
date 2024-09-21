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
/*You are climbing a staircase. It takes n steps to reach the top. 
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