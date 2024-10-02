import java.io.*;
import java.util.*;
class pairdiff{
    public static void binarySearch(int arr[],int ele,int target,int low,int high){
        while(low<=high){
            int mid = (low+high)/2;
            // if(arr[mid]-ele==target){
            if (Math.abs(arr[mid] - ele) == target){
                System.out.println(ele+" "+arr[mid]);
                return;
            }
            if(arr[mid]-ele<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
    }
    public static void pairDifference(int arr[],int target){
        // int low = 0 , high = arr.length-1 ;
        for(int i = 0 ; i < arr.length ; i++){
            binarySearch(arr,arr[i],target,i+1,arr.length-1);
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        Arrays.sort(arr);
        pairDifference(arr,target);
        
    }
}
/*Mr. Ram works in a manufacturing industry where items of different weights are produced. 
His task is to find pairs of items whose weight difference is equal to a given value k. 
You are asked to write a program to help Mr. Ram achieve this without using extra space.

Input Format:
-------------
Line-1: An integer n, the number of items (weights).
Line-2: n space-separated positive integers representing the weights of the items.
Line3: An integer k, the desired difference between the weights of the paired items.

Output Format:
--------------
Line-1 to n: Print the pairs of integers where the difference between the two numbers in each pair is exactly k.
Each pair should be printed on a new line.

Constraints:
------------
The input list will contain distinct integers.
You are not allowed to use extra space, so you must solve the problem in-place or by using a fixed amount of space.


Sample Input-1:
---------------
8
1 2 3 4 5 6 7 8
3

Sample Output-1:
----------------
1 4
2 5
3 6
4 7
5 8

Sample Input-2:
---------------
10
5 10 15 20 25 30 35 40 45 50
5

Sample Output-2:
----------------
5 10
10 15
15 20
20 25
25 30
30 35
35 40
40 45
45 50
 */