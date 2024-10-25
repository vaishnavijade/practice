
import java.util.*;
public class stroboSmallAndLargest {
    static final char[][] pairs = {
        {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> strobogrammaticNumbers = findStrobogrammatic(n);
        List<Integer> primeStrobogrammatic = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (String num : strobogrammaticNumbers) {
            int number = Integer.parseInt(num);
            if (isPrime(number)) {
                primeStrobogrammatic.add(number);
            }
            if (number < smallest) smallest = number;
            if (number > largest) largest = number;
        }
        Collections.sort(primeStrobogrammatic);
        System.out.println(primeStrobogrammatic);
        System.out.println(smallest + " " + largest);
    }
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
    private static List<String> findStrobogrammatic(int n) {
        return buildStrobogrammatic(n, n);
    }
    private static List<String> buildStrobogrammatic(int n, int totalLength) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> subList = buildStrobogrammatic(n - 2, totalLength);
        List<String> result = new ArrayList<>();
        for (String middle : subList) {
            for (char[] pair : pairs) {
                if (n != totalLength || pair[0] != '0') { 
                    result.add(pair[0] + middle + pair[1]);
                }
            }
        }
        return result;
    }
}
/*A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, print all prime strobogrammatic numbers that are of length n 
and print smallest and largest strobogrammatic numbers of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
Line-1: Return a list of all prime strobogrammatic numbers of length n.
Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11]
11 96


Sample Input-2:
---------------
5

Sample Output-2: 
----------------
[16091, 18181, 19861, 61819]
10001 99866

Sample Input-3:
---------------
4

Sample Output-3: 
----------------
[]
1001 9966

NOTE: Print the results in sorted order to pass the testcases */