package SortingAlgo;

public class BubbleSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int arr[] = {1, 2, 3, 4, 5, 6, 7};

	        bubbleSort(arr);//calling the bubbleSort function

	        System.out.println("Sorted array");

	        printArray(arr); //calling the printArray function
	    }

private static void bubbleSort(int a[])
	    {
	        int len = a.length; // calculating the length of array
	        for (int i = 0; i < len-1; i++) {

	            for (int j = 0; j < len - i - 1; j++) 
	            { 
	                if (a[j] > a[j + 1]) //comparing the pair of elements
	                {
	                    int temp = a[j];
	                    a[j] = a[j + 1];
	                    a[j + 1] = temp;
	                }
	            }
	        }
	    }

	    /* Prints the array */
private static void printArray(int a[])
	    {
	        int len = a.length;
	        for (int i = 0; i < len; i++)
	            System.out.print(a[i] + " "); //printing the sorted array

	        System.out.println();
	    }

}