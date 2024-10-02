import java.util.*;

public class FreezingTempfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read matrix dimensions
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        // Read the temperature grid
        int[][] temperatureGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temperatureGrid[i][j] = sc.nextInt();
            }
        }
        
        // Start from top-right corner
        int row = 0;
        int col = n - 1;
        int count = 0;
        
        // Traverse the grid
        while (row < m && col >= 0) {
            if (temperatureGrid[row][col] < 0) {
                // All elements in the current column below this are also freezing
                count += (m - row);  // Add all remaining rows in this column
                col--;  // Move to the left column
            } else {
                row++;  // Move down to the next row
            }
        }
        
        // Output the count of freezing temperatures
        System.out.println(count);
    }
}
/*Given a m x n matrix temperatureGrid representing the recorded 
temperatures in a region over several days. The matrix is sorted 
in non-increasing order both row-wise and column-wise, meaning 
the temperatures are getting colder as you move right or down. 
Each temperature is recorded in degrees Celsius.

You are tasked with determining the number of freezing temperature 
readings in the grid. In this case, a freezing temperature is 
defined as any temperature less than 0°C.

Constraints:
------------
m == temperatureGrid.length
n == temperatureGrid[i].length
1 <= m, n <= 100
-100 <= temperatureGrid[i][j] <= 100


Input Format:
-------------
Line-1: two space separated integers, M and N
Next M lines : N space separated integers, temperatures grid.

Output Format:
-------------
An integer, number of freezing temperatures


Sample Input-1:
---------------
4 4
10 5 2 -1
7 3 0 -2
5 2 -2 -4
2 -1 -3 -6

Sample Output-1:
----------------
7

Explanation:
------------
There are 7 freezing temperatures (< 0°C) in the matrix: 
-1, -2, -2, -4, -1, -3, -6.

Sample Input-2:
---------------
1 3
12 95 4

Sample Output-2: 
----------------
0

Explanation:
------------
There are no freezing temperatures in the matrix.
 */