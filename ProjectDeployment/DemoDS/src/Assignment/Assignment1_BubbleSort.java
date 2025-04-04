package Assignment;
import java.util.*;
public class Assignment1_BubbleSort {
	    public static void main(String[] args) {
	        int[] arr1 = {5, 3, 8, 4, 2};  // Random order
	        int[] arr2 = {1, 2, 3, 4, 5};  // Already sorted
	        int[] arr3 = {5, 4, 3, 2, 1};  // Reverse order

	        System.out.println("Sorting arr1: " + Arrays.toString(arr1));
	        long startime = System.nanoTime();
	        bubbleSort(arr1);
	        long endtime = System.nanoTime();
	        
	        System.out.println("Execution time for ARRAY 1: "+ (endtime-startime)/ 1000000 + " milliseconds");
	        
	        System.out.println("Sorting arr2: " + Arrays.toString(arr2));
	        startime = System.nanoTime();
	        bubbleSort(arr2);
	        endtime = System.nanoTime();
	        
	        System.out.println("Execution time for ARRAY 2"+ (endtime-startime)/ 1000000 + " milliseconds");

	        System.out.println("Sorting arr3: " + Arrays.toString(arr3));
	        startime = System.nanoTime();
	        bubbleSort(arr3);
	        endtime = System.nanoTime();
	        
	        System.out.println("Execution time for ARRAY 3 "+ (endtime-startime)/ 1000000 + " milliseconds");
	    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false; //optimized bubble sort
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //System.out.println("Intermidiate Sorted Array: " + Arrays.toString(arr));
                    swapCount++;
                    swapped = true;
                }
            }

            // If no swaps happened, the array is already sorted
            if (!swapped) break;
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Total Swaps: " + swapCount);
        System.out.println("-------------------------");
    }
}
