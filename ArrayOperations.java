package arrays;

import java.util.Arrays;

/**
 * Array Traversal, Insertion, Deletion, Search.
 *
 * Memory: Arrays are stored in contiguous memory locations, which is why
 * random access is O(1) -> address = base_address + (index * element_size).
 *
 * When to use Arrays:
 *  - Fast random access needed (O(1) by index)
 *  - Size is known/fixed ahead of time
 *  - Cache-friendly (contiguous memory) -> good for numeric/heavy iteration workloads
 * When NOT to use:
 *  - Frequent insertions/deletions in the middle (O(n) shift cost)
 *  - Unknown/rapidly changing size (use ArrayList/LinkedList instead)
 */
public class ArrayOperations {

    // Traversal - O(n)
    public static void traverse(int[] arr) {
        System.out.print("Traversal: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Search - O(n) for unsorted array
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Insertion at a given index - O(n) due to shifting
    public static int[] insert(int[] arr, int index, int value) {
        int[] result = new int[arr.length + 1];
        for (int i = 0, j = 0; i < result.length; i++) {
            if (i == index) {
                result[i] = value;
            } else {
                result[i] = arr[j++];
            }
        }
        return result;
    }

    // Deletion at a given index - O(n) due to shifting
    public static int[] delete(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                result[j++] = arr[i];
            }
        }
        return result;
    }

    public static void run() {
        System.out.println("=== Array Operations Demo ===");
        int[] arr = {10, 20, 30, 40, 50};
        traverse(arr);

        System.out.println("Search 30 -> index " + search(arr, 30));

        int[] afterInsert = insert(arr, 2, 99);
        System.out.println("After inserting 99 at index 2: " + Arrays.toString(afterInsert));

        int[] afterDelete = delete(afterInsert, 0);
        System.out.println("After deleting index 0: " + Arrays.toString(afterDelete));
    }
}
