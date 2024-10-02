import java.util.*;
public class mergeSortt{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        mergeSort(arr,0,n-1);
        for(int num:arr){
            System.out.println(num+" ");
        }
    }
    public static void mergeSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
       int n=high-low+1;//size of segment
       int[] temp=new int[n];
       int left=low;
       int right=mid+1;
       int k=0;
       while(left<=mid && right<=high){  //merging two halves
           if(arr[left]<=arr[right]){
               temp[k++]=arr[left++];
           }else{
               temp[k++]=arr[right++];
           }
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for(int i=0;i<n;i++){
            arr[low+i]=temp[i];
        }
    } 
}
/*You are given an unsorted array of integers. 
Your task is to implement the MergeSort algorithm to sort the array in ascending order.

MergeSort is a divide-and-conquer algorithm that:
	-Divides the array into two halves.
	-Recursively sorts the two halves.
	-Merges the two sorted halves to produce the final sorted array.
	-Your task is to write a function that sorts the given array using MergeSort.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
---------------
Line-1: Output the sorted array in a single line, with each element separated by a space.

Constraints:
------------
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9


Sample Input-1:
---------------
6
12 11 13 5 6 7

Sample Output-1:
----------------
5 6 7 11 12 13


Sample Input-2:
---------------
5
10 1 2 8 5

Sample Output-2:
----------------
1 2 5 8 10
 */