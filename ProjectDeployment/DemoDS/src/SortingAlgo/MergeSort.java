package SortingAlgo;

import java.util.*;

public class MergeSort {
	    public static void main(String[] args) {
	        int[] arr = {13, 11, 14, 12, 15, 16, 18, 17};

	        int[] sortedArray = mergeSort(arr);
	        System.out.println(Arrays.toString(arr));
	        System.out.println(Arrays.toString(sortedArray));
	    }

	    private static int[] mergeSort(int[] arr) {
	        if (arr.length == 1) {
	            return arr;
	        }
	        int midIndex = arr.length / 2;

	        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
	        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

	        return merge(left, right);
	    }
	   private static int[] merge(int[] left, int[] right) {
		
			int[] combined = new int[left.length + right.length];
			int index = 0;
			int i = 0;
			int j = 0;

			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					combined[index] = left[i];
					index++;
					i++;
				} else {
					combined[index] = right[j];
					index++;
					j++;
				}
			}
			while (i < left.length) {
				combined[index] = left[i];
				index++;
				i++;
			}
			while (j < right.length) {
				combined[index] = right[j];
				index++;
				j++;
			}

			return combined;
		}
}