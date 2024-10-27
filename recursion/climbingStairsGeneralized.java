import java.util.*;

class climbingStairsGeneralized {
    // A recursive function used by countWays
    static int countWaysUtil(int n, int m) {
        if (n <= 2)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);
        return res;
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m) {
        return countWaysUtil(s, m);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total no.of stairs");
        int s = sc.nextInt();
        System.out.println("enter possible stairs ");
        int m = sc.nextInt();
        System.out.println("Number of ways = "
                + countWays(s, m));
    }
}
