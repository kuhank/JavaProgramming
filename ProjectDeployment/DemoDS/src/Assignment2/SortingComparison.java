package Assignment2;

import java.util.Arrays;

public class SortingComparison {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 90, 88, 76, 45, 32};

        compareSortingAlgorithms(arr);
    }

    private static void compareSortingAlgorithms(int[] arr) {
        int[] arrCopy;
        
        arrCopy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        bubbleSort(arrCopy);
        long end = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (end - start) + " ns");

        arrCopy = Arrays.copyOf(arr, arr.length);
        start = System.nanoTime();
        insertionSort(arrCopy);
        end = System.nanoTime();
        System.out.println("Insertion Sort Time: " + (end - start) + " ns");

        arrCopy = Arrays.copyOf(arr, arr.length);
        start = System.nanoTime();
        selectionSort(arrCopy);
        end = System.nanoTime();
        System.out.println("Selection Sort Time: " + (end - start) + " ns");

        arrCopy = Arrays.copyOf(arr, arr.length);
        start = System.nanoTime();
        mergeSort(arrCopy);
        end = System.nanoTime();
        System.out.println("Merge Sort Time: " + (end - start) + " ns");

        arrCopy = Arrays.copyOf(arr, arr.length);
        start = System.nanoTime();
        quickSort(arrCopy, 0, arrCopy.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start) + " ns");
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
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

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
