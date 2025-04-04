package Hashing;

import java.util.Arrays;

class FibHashTable {
    private int[] keys; //storing the n value in fib(n)
    private long[] values; //storing the value of fib(n)
    private int size; //size of hash table

    public FibHashTable(int size) { //initialisation
        this.size = size;
        keys = new int[size];
        values = new long[size];
        Arrays.fill(keys, -1);
    }

    private int hash(int key) { //hashing table index creation
        return key % size;
    }

    public void put(int key, long value) { //assign hashing table values and index
        int index = hash(key);
        int i = 0;
        while (keys[(index + i) % size] != -1 && keys[(index + i) % size] != key) {
            i++;
        }
        int finalIndex = (index + i) % size;
        keys[finalIndex] = key;
        values[finalIndex] = value;
        System.out.println("Key :"+ key+ " values : "+ value+" finalindex :"+ finalIndex);
    }

    public long get(int key) { //get values for the n values of fib(n)
        int index = hash(key);
        int i = 0;
        while (keys[(index + i) % size] != -1) {
            if (keys[(index + i) % size] == key) {
                return values[(index + i) % size];
            }
            i++;
        }
        return -1; 
    }

    public boolean containsKey(int key) {
    	//System.out.println("contains method: "+key);
        int index = hash(key);
        int i = 0;
        while (keys[(index + i) % size] != -1) {
            if (keys[(index + i) % size] == key) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void display() {
        System.out.println("Memoized Fibonacci Table:");
        for (int i = 0; i < size; i++) {
            if (keys[i] != -1) {
                System.out.println("fib(" + keys[i] + ") = " + values[i]);
            }
        }
    }
}

public class FibonacciWithHashing {
    static FibHashTable fibObj= new FibHashTable(10);

    public static long fib(int n) {
        if (n <= 1) return n;

        if (fibObj.containsKey(n)) {
        	System.out.println("repeated values taken from hash table for feb("+n+") is : "+ fibObj.get(n));
            return fibObj.get(n);
        }

        long result = fib(n - 1) + fib(n - 2);
        fibObj.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
        fibObj.display();
    }
}

