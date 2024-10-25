package greedy;
import java.util.*;
public class digitSwap{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=maximumSwap(n);
        System.out.println(res);
    }
    public static int maximumSwap(int num){
        char[] dig=Integer.toString(num).toCharArray();
        int[] last=new int[10];//to store last occurence of dig
        for (int i=0;i<dig.length;i++){
            last[dig[i]-'0']=i;
        }
        for(int i=0;i<dig.length;i++){
            for(int d=9;d>dig[i]-'0';d--){
                if(last[d]>i){
                    char temp=dig[i];
                    dig[i]=dig[last[d]];
                    dig[last[d]]=temp;
                    
                    return Integer.parseInt(new String(dig));
                }
            }
        }
        return num;
    }
}
/*You are given an integer num. Your task is to maximize its value by swapping at most two digits once. 
Write a program to return the maximum possible value after performing the swap.

If no swap can increase the value, return the original number.

Input Format:
--------------
Line-1: An integer num, where 0 <= num <= 10^8.

Output Format:
--------------
Line-1: Return an integer representing the maximum value obtained after swapping two digits at most once.

Sample Input-1:
---------------
2736

Sample Output-1:
----------------
7236

Explanation:
------------
Swap the digit 2 with 7, resulting in the number 7236, which is the maximum possible value.

Sample Input-2:
---------------
9973

Sample Output-2:
----------------
9973

Explanation:
------------
No swap can make the number larger, so return the original number. */
