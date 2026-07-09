package searching;

/** Linear Search - O(n) and Binary Search - O(log n) (iterative + recursive). */
public class SearchingAlgorithms {

    // Works on unsorted arrays. Best case O(1), Worst/Average O(n).
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Requires a SORTED array. O(log n).
    public static int binarySearchIterative(int[] sortedArr, int target) {
        int low = 0, high = sortedArr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) return mid;
            else if (sortedArr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Recursive version - O(log n) time, O(log n) space due to call stack.
    public static int binarySearchRecursive(int[] sortedArr, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (sortedArr[mid] == target) return mid;
        else if (sortedArr[mid] < target) return binarySearchRecursive(sortedArr, target, mid + 1, high);
        else return binarySearchRecursive(sortedArr, target, low, mid - 1);
    }

    public static void run() {
        System.out.println("=== Searching Algorithms Demo ===");
        int[] unsorted = {23, 4, 67, 12, 89, 3};
        int[] sorted = {2, 5, 8, 12, 16, 23, 42, 67};

        System.out.println("Linear search for 67 -> index " + linearSearch(unsorted, 67));
        System.out.println("Binary search (iterative) for 42 -> index " + binarySearchIterative(sorted, 42));
        System.out.println("Binary search (recursive) for 2 -> index "
                + binarySearchRecursive(sorted, 2, 0, sorted.length - 1));
        System.out.println("Binary search for missing value 99 -> index " + binarySearchIterative(sorted, 99));
    }
}
