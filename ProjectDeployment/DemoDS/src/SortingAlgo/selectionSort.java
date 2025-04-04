package SortingAlgo;

import java.util.Arrays;

public class selectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method to test selection sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
