package SortingAlgo;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
}

    private static void insertionSort(int[] arr) {
        int n = arr.length;

        // Iterate over the array starting from the second element
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // The current element to be inserted into the sorted part of the array
            int j = i - 1;

            // Shift elements that are greater than the key to one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key at its correct position
            arr[j + 1] = key;
        }
    }
    
}
