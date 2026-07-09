package complexity;

/**
 * Demonstrates Time & Space Complexity concepts:
 * - Constant, Linear, Quadratic, Logarithmic time examples
 * - Best / Average / Worst case analysis
 * - Iterative vs Recursive complexity
 */
public class ComplexityAnalysis {

    // O(1) - Constant time: no loops, direct access
    public static int constantTime(int[] arr) {
        return arr.length == 0 ? -1 : arr[0];
    }

    // O(n) - Linear time: single pass
    public static int linearTime(int[] arr, int target) {
        for (int val : arr) {
            if (val == target) return val;
        }
        return -1;
    }

    // O(n^2) - Quadratic time: nested loops
    public static void quadraticTime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // e.g. comparing every pair - used in bubble sort
                System.out.print(arr[i] + arr[j] + " ");
            }
        }
        System.out.println();
    }

    // O(log n) - Logarithmic time: halving search space each step
    public static int logarithmicTime(int[] sortedArr, int target) {
        int low = 0, high = sortedArr.length - 1;
        int steps = 0;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) {
                System.out.println("Found in " + steps + " steps (log n behavior)");
                return mid;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Recursive time complexity example: Fibonacci -> O(2^n) naive, O(n) memoized
    public static int fibonacciNaive(int n) {
        if (n <= 1) return n;
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2); // O(2^n)
    }

    public static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo); // O(n)
        return memo[n];
    }

    /*
     * Best / Average / Worst case — illustrated using Linear Search:
     * Best case:    O(1)  -> target is the first element
     * Average case: O(n)  -> target is somewhere in the middle
     * Worst case:   O(n)  -> target is the last element or absent
     */
    public static void demonstrateCases(int[] arr, int best, int worst) {
        System.out.println("Best case search (first element): result = " + linearTime(arr, best));
        System.out.println("Worst case search (absent element): result = " + linearTime(arr, worst));
    }

    public static void run() {
        System.out.println("=== Complexity Analysis Demo ===");
        int[] arr = {5, 3, 8, 1, 9, 2, 7};
        int[] sorted = {1, 2, 3, 5, 7, 8, 9};

        System.out.println("O(1) constant time -> " + constantTime(arr));
        System.out.println("O(n) linear time search for 9 -> " + linearTime(arr, 9));
        System.out.println("O(log n) binary search for 7:");
        logarithmicTime(sorted, 7);

        System.out.println("Fibonacci(10) naive (O(2^n))  -> " + fibonacciNaive(10));
        System.out.println("Fibonacci(10) memoized (O(n)) -> " + fibonacciMemo(10, new int[11]));

        demonstrateCases(arr, 5, 100);
    }
}
