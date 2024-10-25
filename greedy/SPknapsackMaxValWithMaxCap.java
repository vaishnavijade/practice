package greedy;

import java.util.*;
class Knapsack {
    public double getMaxValue(int n, int W, double[][] itemVal) {
        Arrays.sort(itemVal, (a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));
        double totalValue = 0.0;
        int remainingCapacity = W;

        for (int i = 0; i < n; i++) {
            if (remainingCapacity == 0) {
                break;
            }
            if (itemVal[i][1] <= remainingCapacity) {
                totalValue += itemVal[i][0];
                remainingCapacity -= itemVal[i][1];
            } else {
                totalValue += (itemVal[i][0] / itemVal[i][1]) * remainingCapacity;
                remainingCapacity = 0;
            }
        }
        return totalValue;
    }
}

public class SPknapsackMaxValWithMaxCap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        double[][] itemVal = new double[n][2];
        for (int i = 0; i < n; i++) {
            itemVal[i][0] = sc.nextInt();
            itemVal[i][1] = sc.nextInt();
        }

        Knapsack knapsack = new Knapsack();
        double result = knapsack.getMaxValue(n, W, itemVal);
        System.out.printf("%.2f\n", result);
    }
}
/*You are given n items, each with a specific weight and value. 
You are also given a knapsack that can hold a maximum weight W. 
The goal is to maximize the total value in the knapsack by selecting items to add.
fractional knapsack
NOTE: You can take fractions of items instead of having to take the whole item. 
You need to calculate the maximum possible value that can be achieved.

Input Format:
-------------
Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
Line-2 to n: Each line contains two integers value and weight for each item.

Output Format:
--------------
Line-1: Printing the maximum total value that can be obtained in the knapsack, rounded to two decimal places.

Constraints:
-------------
1 <= n <= 10^5
0 <= W <= 10^9
1 <= value, weight <= 10^9

Sample Input-1:
---------------
3 50
60 10
100 20
120 30

Sample Output-1:
----------------
240.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 10).
The second item can be added in full (value = 100, weight = 20).
The third item can be added partially, using only 20 out of 30 weight capacity, which gives a value of (120/30) * 20 = 80.
Thus, the total value is 60 + 100 + 80 = 240.

Sample Input-2:
---------------
2 50
60 20
100 50

Sample Output-2:
----------------
160.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 20).
From the second item, only 30 weight units can be used, so the value will be (100/50) * 30 = 60.
Thus, the total value is 60 + 60 = 160.

Sample Input-3:
---------------
1 10
500 30

Sample Output-3:
----------------
166.67

Explanation:
------------
The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
The value of 10 units from the first item is (500/30) * 10 = 166.67.
Thus, the total value is 166.67 */




/*0-1 knapsack is not as optimal compared to fractional
 in 0-1 we are not allowed to break items cant solve using greedy but we can use dp for 0-1 
*/