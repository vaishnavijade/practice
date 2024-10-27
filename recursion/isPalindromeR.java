import java.util.*;
public class isPalindromeR{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        System.out.println(isPalindrome(n));
    }
    public static boolean isPalindrome(String n){
        if(n.length()<=1){
            return true;
        }
        else{
            char firstChar=n.charAt(0);
            char lastChar=n.charAt(n.length()-1);
            if(firstChar == lastChar){
                return isPalindrome(n.substring(1,n.length()-1));
            }else{
                return false;
            }
        }
    }
}








import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();    
        System.out.println(isPalindrome(input));
    }
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/*In your English exam, there is a question that asks you to check whether a given string is a palindrome. Using your programming skills, you need to write a program that prints True if the string is the same when reversed, and False otherwise.

A palindrome is a word, phrase, or sequence that reads the same backward as forward.

Input Format:
--------------
Line-1: A single string str, which may contain lowercase letters.

Output Format:
---------------
Line-1: Print True if the string is a palindrome, otherwise print False.

Constraints:
------------
The string can contain up to 1000 characters.


Sample Input-1: 
---------------
liril

Sample Output-1: 
----------------
True

Sample Input-2: 
---------------
genesis

Sample Output-2: 
----------------
False */
