import java.util.Arrays;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Each element is its own subsequence, so start with length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // The length of the longest increasing subsequence is the maximum value in dp[]
        int lisLength = 0;
        for (int length : dp) {
            lisLength = Math.max(lisLength, length);
        }

        return lisLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lengthOfLIS(nums1));  // Output: 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS: " + lengthOfLIS(nums2));  // Output: 4
    }
}
