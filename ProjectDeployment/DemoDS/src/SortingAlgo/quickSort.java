package SortingAlgo;

import java.util.Arrays;

public class quickSort {

public static void main(String[] args) {
	int[] myarr = {4, 2, 6, 7, 1, 3, 5};   //  1 , 2 , 3 , 4 , 5 , 6 , 7
	quickSort(myarr);
	System.out.println("\nFinal Sorted Array:\n"+Arrays.toString(myarr));
}

private static void quickSort(int[] arr) {
	quickSortHelper(arr, 0 , arr.length-1);
}

private static void quickSortHelper(int[] arr, int left, int right) {
	if(left < right) {
		System.out.println("Array Entering Loops: "+Arrays.toString(Arrays.copyOfRange(arr, left, right+1)));
		int pivotIndex = pivot(arr, left, right);
		quickSortHelper(arr, left, pivotIndex -1);
		quickSortHelper(arr, pivotIndex+1, right);
	}
}

private static int pivot(int[] arr, int startIndex, int endIndex) {
	int swapIndex = startIndex;
	for(int i = startIndex + 1 ; i<=endIndex ;i++) {
		if(arr[i] < arr[startIndex]) {
			swapIndex++;
			swap(arr, swapIndex, i);
		}		
	}
	swap(arr, startIndex, swapIndex);
	return swapIndex;
}

private static void swap(int[] arr, int firstIndex, int secondIndex) {
	int temp = arr[firstIndex];
	arr[firstIndex] = arr[secondIndex];
	arr[secondIndex] = temp;
}
}