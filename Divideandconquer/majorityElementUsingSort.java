import java.util.*;
class majorityElementUsingSort {
    public int majorityElement(int[] nums) {
        return findMajorityElement(nums, 0, nums.length - 1);
    }
    
    private int findMajorityElement(int[] nums, int left, int right) {
        // Base case: if the range has only one element
        if (left == right) {
            return nums[left];
        }
        
        // Divide: find the mid-point
        int mid = left + (right - left) / 2;
        
        // Conquer: find majority element in both halves
        int leftMajority = findMajorityElement(nums, left, mid);
        int rightMajority = findMajorityElement(nums, mid + 1, right);
        
        // If both halves agree on the majority element, return it
        if (leftMajority == rightMajority) {
            return leftMajority;
        }
        
        // Count occurrences of each candidate
        int leftCount = countOccurrences(nums, leftMajority, left, right);
        int rightCount = countOccurrences(nums, rightMajority, left, right);
        
        // Determine which candidate is the majority
        return leftCount > rightCount ? leftMajority : rightMajority;
    }
    
    private int countOccurrences(int[] nums, int candidate, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // Create an instance of Solution and find the majority element
        majorityElementUsingSort solution = new majorityElementUsingSort();
        int result = solution.majorityElement(nums);
        
        // Print the result
        System.out.println(result);
        
        scanner.close();
    }
}
/*Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Output a single integer, the majority element.

Constraints:
-------------
1 ≤ n ≤ 5 * 10^4
-10^9 ≤ nums[i] ≤ 10^9


Sample Input-1:
---------------
3
3 2 3

Sample Output-1:
----------------
3

Explanation:
The number 3 appears more than n/2 times, so it is the majority element.

Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.
 */
