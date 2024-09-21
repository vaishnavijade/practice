import java.util.*;
public class reverseStringg{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] arr=s.toCharArray();
        
        reverseString(arr,0,s.length()-1);
        System.out.println(arr);
    }
    public static void reverseString(char[] s, int left, int right){
        if(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            reverseString (s,left+1,right-1);
        }
        
    }
}
/*Given a string s, write a recursive function to reverse the string. 
You are not allowed to use any built-in string manipulation functions. 

Constraints:
------------
The input string s consists of printable ASCII characters (including spaces, punctuation, etc.).
The length of the string s is between 1 and 1000.
You must reverse the string recursively.

Input Format:
--------------
Line-1: A single string s, containing characters that need to be reversed.

Output Format:
--------------
Line-1: A single string, representing the reversed input string.


Sample Input-1: 
---------------
hello

Sample Output-1:
-----------------
olleh

Sample Input-2:
----------------
12345

Sample Output-2: 
----------------
54321
 */
