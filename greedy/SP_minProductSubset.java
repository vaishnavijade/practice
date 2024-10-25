package greedy;

import java.util.*;

class SP_minProductSubset {
	public static int minProductSubset(int a[], int n)
	{
		if (n == 1)
			return a[0];
		int negmax = Integer.MIN_VALUE;
		int posmin = Integer.MAX_VALUE;
		int count_neg = 0, count_zero = 0;
		int product = 1;

		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				count_zero++;
				continue;
			}
			if (a[i] < 0) {
				count_neg++;
				negmax = Math.max(negmax, a[i]);
			}
			if (a[i] > 0 && a[i] < posmin)
				posmin = a[i];

			product *= a[i];
		}

		//System.out.println("count_zero " + count_zero + " negmax " + negmax);
		if (count_zero == n
			|| (count_neg == 0 && count_zero > 0))
			return 0;
	
		if (count_neg == 0)
			return posmin;
		if (count_neg % 2 == 0 && count_neg != 0) {
			product = product / negmax;
		}
		return product;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[] = new int[n];

		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println(minProductSubset(a, n));
	}
}

/*You are given an array of integers that can include both positive and negative numbers. 
Your task is to find the minimum possible product of a non-empty subset of the given array.

Rules:
-The subset must contain at least one element.
-The product is the result of multiplying all the numbers in the subset.
-If the array contains only one element, that element is the result.
-You can ignore zeros in the subset product calculation.

Input Format:
-------------
Line-1: An integer N, the number of elements in the array.
Line-2: N space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Print a single integer representing the minimum product possible from a subset of the given array.

Constraints:
------------
1 ≤ N ≤ 100
-1000 ≤ array[i] ≤ 1000

Sample Input-1:
---------------
5
-1 -1 -2 4 3

Sample Output-1:
----------------
-24

Explanation: The minimum product can be achieved by choosing the subset {-1, -1, -2, 4} which results in the product -24.

Sample Input-2:
---------------
3
-1 0 -2

Sample Output-2
----------------
-2

Explanation: Since zeroes can be ignored, the minimum product is -2, achieved by the subset {-2}.

Sample Input-3:
---------------
6
2 3 4 5 -1 -2

Sample Output-3:
----------------
-240
Explanation: By choosing the subset {2, 3, 4, 5, -1, -2}, the minimum product is -240. */
