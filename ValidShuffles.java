
public class ValidShuffles {

    public static void main(String[] args) {
        int N = 3; // Replace with your input value
        System.out.println("Number of valid shuffles: " + countValidShuffles(N));
    }

    public static int countValidShuffles(int N) {
        boolean[] visited = new boolean[N + 1]; // Tracks used numbers
        return backtrack(N, 1, visited);
    }

    private static int backtrack(int N, int position, boolean[] visited) {
        // Base case: all positions are filled
        if (position > N) {
            return 1;
        }

        int count = 0;

        // Try placing each number in the current position
        for (int num = 1; num <= N; num++) {
            if (!visited[num] && isValid(num, position)) {
                // Mark the number as used
                visited[num] = true;

                // Recurse to the next position
                count += backtrack(N, position + 1, visited);

                // Backtrack: unmark the number
                visited[num] = false;
            }
        }
        return count;
    }

    private static boolean isValid(int num, int position) {
        // Check if the number satisfies the divisibility condition
        return num % position == 0 || position % num == 0;
    }
}

/*Ganesh is working on numbers, He is given a list of integers 1,2,3,...,N 
and the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want. Shuffled list is said 
to be valid, if one of the following is true for i-th position in the list.
	- The integer at the i-th position is divisible by i.
	- 'i' is divisible by the integer at the i-th position.

Your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1

Explanation:
------------
The only shuffled list is [1]


Sample Input-2:
---------------
2

Sample Output-2:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.


Sample Input-3:
---------------
3

Sample Output-3:
----------------
3

Explanation:
------------
The first shuffled list is [1, 2, 3]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).

The second shuffled list is [3, 2, 1]:
Integer at the 1st position (i=1) is 3, and 3 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 1, and i is divisible by 1 (i=3).

The third shuffled list is [2, 1, 3]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i is divisible by 1 (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).
 */
