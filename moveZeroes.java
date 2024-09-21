import java.util.*;
public class moveZeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        moveZeroess(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
     public static void moveZeroess(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt++;
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
     }
}
/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
The operation should be performed in-place without making a copy of the array, and the time complexity should be minimized.

Constraints:
------------
nums contains only integers.
You must maintain the relative order of the non-zero elements.
The operation must be done in-place with O(1) extra space.

Input Format:
-------------
Line-1: An integer, size of the array
Line-2 to n: A single array of integers nums with at least one element.

Output Format:
-------------
Line-1: The modified input array nums, where all zeros are moved to the end while maintaining the relative order of the non-zero elements.

Sample Input-1:
----------------
5
0 1 0 3 12

Sample Output-1:
----------------
1 3 12 0 0

Sample Input-2:
---------------
1
0

Sample Output-2:
-----------------
0
 */