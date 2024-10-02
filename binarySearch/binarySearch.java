import java.util.*;
public class binarySearch{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ele=sc.nextInt();
        int res=binarySearchhh(arr,0,n-1,ele);
        System.out.println(res);
        
    }
    public static int binarySearchhh(int[] arr,int low,int high,int ele){
        int mid=(low+high)/2;
        while(high>low){
            if (arr[mid]==ele) return mid;
            else if(ele<arr[mid])return binarySearchhh(arr,low,mid-1,ele);
            return binarySearchhh(arr,mid+1,high,ele);
        }
        return -1;
    }
}
/*You are given a sorted array of integers and a target integer. 
Your task is to write a program that uses binary search to find the index of the target integer in the array. 
If the target is found, return its index. If the target is not found, return -1.
Your solution must have a time complexity of O(log n), where n is the number of elements in the array.

Input Format:
--------------
Line-1: An integer n (the number of elements in the array).
Line-2: n space-separated integers, representing the sorted array.
Line-3: An integer target, the value you need to search for in the array.

Output Format:
---------------
Line-1: Print a single integer, which is the index of the target element in the array. If the target is not found, print -1.

Constraints:
-------------
1 ≤ n ≤ 10^6 (size of the array)
-10^9 ≤ arr[i], target ≤ 10^9 (array elements and target value)
The array is sorted in non-decreasing order.


Sample Input-1:
---------------
6
1 3 5 7 9 11
5

Sample Output-1:
----------------
2

Explanation:
The target 5 is found at index 2.


Sample Input-2:
---------------
5
2 4 6 8 10
7

Sample Output-2:
----------------
-1

Explanation:
The target 7 is not found in the array, so the output is -1. */