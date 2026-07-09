package sorting;

import java.util.Arrays;

/** Bubble, Insertion, Quick, Merge, Heap Sort with Big-O notes for each. */
public class SortingAlgorithms {

    // Best O(n) (already sorted, with early-exit flag) | Avg/Worst O(n^2) | Space O(1) | Stable
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // best-case optimization
        }
    }

    // Best O(n) | Avg/Worst O(n^2) | Space O(1) | Stable
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Best/Avg O(n log n) | Worst O(n^2) (bad pivot choice) | Space O(log n) | Not stable
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    // Best/Avg/Worst O(n log n) | Space O(n) | Stable
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Best/Avg/Worst O(n log n) | Space O(1) | Not stable
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    public static void run() {
        System.out.println("=== Sorting Algorithms Demo ===");
        int[] base = {64, 25, 12, 22, 11, 90, 5};

        int[] a1 = base.clone(); bubbleSort(a1);
        System.out.println("Bubble Sort:    " + Arrays.toString(a1));

        int[] a2 = base.clone(); insertionSort(a2);
        System.out.println("Insertion Sort: " + Arrays.toString(a2));

        int[] a3 = base.clone(); quickSort(a3, 0, a3.length - 1);
        System.out.println("Quick Sort:     " + Arrays.toString(a3));

        int[] a4 = base.clone(); mergeSort(a4, 0, a4.length - 1);
        System.out.println("Merge Sort:     " + Arrays.toString(a4));

        int[] a5 = base.clone(); heapSort(a5);
        System.out.println("Heap Sort:      " + Arrays.toString(a5));
    }
}
