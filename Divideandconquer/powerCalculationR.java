import java.util.*;
public class powerCalculationR{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        System.out.printf("%.6f",pow(n,p));
    }
    public static float pow(int n,int p){
        if(p==0) return 1.0f;
        float ans=pow(n,p/2);
        if(p%2==0){
            return ans*ans;
        }
        else{
            if(p>0) return n*ans*ans;
            else return (ans*ans)/n;
        }
    }
}
/*A school kid named John Doe, wants to find the value of N^P
Pth power of a number N.

You will be given two integers N and P.
Your task is to help John Doe to find the value of N^P.

NOTE:
---------
Value of N and P can be both positive and negative

Input Format:
-------------
Line-1: Two integers N and P, where N is the number and P is the power

Output Format:
--------------
Line-1: Print a float number, N power P


Sample Input-1:
---------------
3 2

Sample Output-1:
----------------
9.000000


Sample Input-2:
---------------
2 -3

Sample Output-2:
----------------
0.125000 */