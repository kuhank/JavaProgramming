package Searching;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 9}; // Sorted array (required for binary search)

        System.out.println("Enter any number 1-10");
        Scanner scn = new Scanner(System.in);
        int targetElement = scn.nextInt(); 
        
        int resultIndex = binarySearch(array, targetElement);
        if (resultIndex != -1) {
            System.out.println("Element found at index " + resultIndex);
        } else {
            System.out.println("Element NOT found in the array");
        }
        
        scn.close(); // Close scanner to avoid resource leak
    }
    
    private static int binarySearch(int[] sortedArray, int targetElement) {
        int left = 0;
        int right = sortedArray.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Checking index: " + mid); // Debugging output

            if (sortedArray[mid] == targetElement) {
                return mid; // Element found, return index
            }
            
            if (sortedArray[mid] < targetElement) { // Search right half
                left = mid + 1;
            } else { // Search left half
                right = mid - 1;
            }
        }
        
        return -1; // Element not found
    }
}
