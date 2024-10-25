package binarySearch;

import java.util.*;
public class longestCommonPrefixx{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        sc.nextLine(); 
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        System.out.println(longestCommonPrefix(str));
    }
    public static boolean isPrefix(String[] str,int len){
        String prefix=str[0].substring(0,len);
        for(int i=0;i<str.length;i++){
            if(!str[i].startsWith(prefix))return false;
        }
        return true;
    }
    public static String longestCommonPrefix(String[] str){
        if (str==null|| str.length==0)return "";
        int minLen=str[0].length();
        for(int i=1;i<str.length;i++) minLen=Math.min(minLen,str[i].length());
        int low=0;
        int high=minLen;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPrefix(str,mid))low= mid+1;
            else high=mid-1;
        }
        return str[0].substring(0,(low+high)/2);
    }
    
}







/*Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.*/
