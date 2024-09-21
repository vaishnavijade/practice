import java.util.*;
public class removeDupSortedArr{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int len=returnlen(arr);
        System.out.println(len);
    }
    public static int returnlen(int arr[]){
        int n=arr.length;
        int count=1;
        for(int i=0;i<n-1;i++){
            if(arr[i]!=arr[i+1]){
                count++;
            }
        }
        return count;
    }
}

/*Given a sorted array of integers, modify the array in place to remove the duplicates such that each element appears only once. 
You task is to return the new length of the array after duplicates are removed. 

You must do this with O(1) extra space (i.e., modify the array in place) and O(n) time complexity.

Input Format:
-------------
Line-1: An integer n, represents size of array.
Line-2 to n: A sorted integer array arr of length n.

Output Format:
--------------
Line-1: An integer, the new length of the array after removing the duplicates.

Constraints:
------------
You must modify the input array in place with O(1) extra memory.
The relative order of the elements should be preserved.
The function should run in O(n) time complexity.

Sample Input-1:
----------------
3
1 1 2

Sample Output-1:
-----------------
2

Explanation: The new length is 2, and the array becomes [1, 2].

Sample Input-2:
---------------
10
0 0 1 1 1 2 2 3 3 4

Sample Output-2:
-----------------
5

Explanation: The new length is 5, and the array becomes [0, 1, 2, 3, 4].*/
