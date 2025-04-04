package Searching;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 1, 9, 6};
        System.out.println("Enter any number 1-10");
        Scanner scn = new Scanner(System.in);
        int targetElement = scn.nextInt();

        int resultIndex = linearSearch(array, targetElement);
        if (resultIndex != -1) {
            System.out.println("Element found at index " + resultIndex);
        } else {
            System.out.println("Element NOT found in the array");
        }
}

private static int linearSearch(int[] array, int targetElement) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == targetElement) {
            return i;
        		}
    		}
		return -1;
		}
	}

