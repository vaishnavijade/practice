import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strobo {
    public static List<String> findStrobogrammatic(int n) {
        return generateStrobogrammatic(n, n);
    }

    private static List<String> generateStrobogrammatic(int n, int m) {
        if (n == 0) {
            return Arrays.asList(""); // Base case: empty string
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8"); // Base case: single-digit strobogrammatic numbers
        }

        List<String> result = new ArrayList<>();
        List<String> inner = generateStrobogrammatic(n - 2, m);

        for (String s : inner) {
            if (n != m) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 2;
        List<String> result1 = findStrobogrammatic(n1);
        System.out.println("Strobogrammatic numbers of length " + n1 + ": " + result1);

        int n2 = 1;
        List<String> result2 = findStrobogrammatic(n2);
        System.out.println("Strobogrammatic numbers of length " + n2 + ": " + result2);
    }
}