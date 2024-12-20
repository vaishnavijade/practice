import java.util.*;
public class Quicksort{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
       arr=qs(arr);
       for(int num:arr){
           System.out.println(num +" ");
       }
       
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j) swap (arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pIndex=partition(arr,low,high);
            quickSort(arr,low,pIndex-1);
            quickSort(arr,pIndex+1,high);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] qs(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    
} 



/* 
import java.util.*;
class Quicksort
{ 
	public static void swap (int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	// selects last element as pivot, pi using which array is partitioned. 
	static int partition_high(int arr[], int low, int high)   
	{ 
        int pivot = arr[high]; 
		System.out.println("low " + low + " high " + high + " pivot " + pivot);

        // smaller element index 
        int i = low; 
        for (int j = low; j < high; j++) 
		{ 
            // check if current element is lesser than pivot
            if (arr[j] < pivot) {
				swap(arr, i, j);
				System.out.println("Sorting process:" + " i " + i + " j " + j + " array " + Arrays.toString(arr)); 
				i++;
            } 
        } 
        // swap arr[i] and arr[high] (or pivot) 
		swap(arr, i, high);
		System.out.println("Sorting Array:" + Arrays.toString(arr)); 
        return i; 
    }    

	// selects first element as pivot, pi using which array is partitioned. 
	static int partition_low(int arr[], int low, int high)   
	{ 
		// First element as pivot
        int pivot = arr[low];
        int k = high;
		System.out.println("low " + low + " high " + high + " pivot " + pivot);

        for (int i = high; i > low; i--) {
            if (arr[i] > pivot)
			{
                swap(arr, i, k);
				System.out.println("Sorting process:" + " i " + i + " k " + k + " array " + Arrays.toString(arr)); 
				k--;
			}
        }
        swap(arr, low, k);
		System.out.println("Last Sorting:" + " low " + low + " k " + k + " array " + Arrays.toString(arr)); 

        // As we got pivot element index is high, now pivot element is at its sorted position
        // return pivot element index (high)
        return k;
    }    
   
	// routine to sort the array partitions recursively
	void quick_sort(int intArray[], int low, int high) 
	{ 
        if (low < high) 
		{ 
            // partition the array around pi=>partitioning index and return pi
            int pi = partition_low(intArray, low, high); 
			System.out.println("low " + low + " high " + high + " pi " + pi);
   
            // sort each partition recursively 
            quick_sort(intArray, low, pi-1); 
            quick_sort(intArray, pi+1, high); 
        } 
    } 

	public static void main(String args[])
	{
		// 7
		// 5 2 8 3 1 6 4

		// 6
		// 24 9 29 14 19 27
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");

		int n = sc.nextInt(); 
		int a[]=new int[n];

		System.out.println("enter the elements of array ");
		for(int i=0;i<n;i++)
		{
			a[i] =sc.nextInt();
		}

		// print the original array
		System.out.println ("Original Array: " + Arrays.toString(a));

		// call quick_sort routine using QuickSortR object
		Quicksort obj = new Quicksort(); 
		obj.quick_sort(a, 0, n-1); 

		// print the sorted array
		System.out.println("Sorted Array: " + Arrays.toString(a)); 
	} 
}

/*
Output:
enter array size
5
enter the elements of array 
10
9
5
78
14
Original Array: [10, 9, 5, 78, 14]
Sorted Array: [5, 9, 10, 14, 78]

*/

/*import java.util.*;
public class Solution{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
       }
       arr=qs(arr);
       for(int num:arr){
           System.out.println(num +" ");
       }
       
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j) swap (arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pIndex=partition(arr,low,high);
            quickSort(arr,low,pIndex-1);
            quickSort(arr,pIndex+1,high);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] qs(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    
} */