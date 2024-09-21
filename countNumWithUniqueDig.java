public class countNumWithUniqueDig {

    // Function to count numbers with unique digits
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1; // Base case: only the number 0

        int count = 10; // Count for 1-digit numbers (0 to 9)
        int availableDigits = 9; // Available digits for subsequent positions
        int currentCount = 9; // Number of valid choices for the first digit
        
        for (int i = 2; i <= n; i++) {
            currentCount *= availableDigits; // Multiply by remaining available digits
            availableDigits--; // Decrease available digits for the next position
            count += currentCount; // Accumulate the total count
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Input: 2 -> Output: " + countNumbersWithUniqueDigits(2)); // Expected output: 91
        System.out.println("Input: 0 -> Output: " + countNumbersWithUniqueDigits(0)); // Expected output: 1
        System.out.println("Input: 3 -> Output: " + countNumbersWithUniqueDigits(3)); // Expected output: 739
        System.out.println("Input: 1 -> Output: " + countNumbersWithUniqueDigits(1));
    }
}

