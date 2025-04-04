package Hashing;

import java.util.Arrays;
import java.util.Random;

class HashTable {
	private int[] table;
	private int tableSize;
	private int a, b, p;

	public HashTable(int size) {
		this.tableSize = size;
		table = new int[tableSize];
		Arrays.fill(table, -1);
		Random rand = new Random();
		p = findNextPrime(size); // p is a prime number which is > the tablesize
		a = rand.nextInt(p - 1) + 1;
		b = rand.nextInt(p);
	}
	
	public int findNextPrime(int size) {
		int prime = size + 1;
		while (!isPrime(prime)) {
			prime++;
		}
		return prime;
	}

	public boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void display() {
		System.out.println(Arrays.toString(table));
	}
	
	public void insertLinear(int key) {
		int index = hash(key);
		int originalIndex = index;
		int i = 0;
		while (table[index] != -1) {
			index = (originalIndex + i++) % tableSize;
		}
		table[index] = key;
	}
	
	public boolean searchLinear(int key) {
		int index = hash(key);
		int originalIndex = index;
		int i = 0;
		while (table[index] != -1) {
			if (table[index] == key)
				return true;
			index = (originalIndex + i++) % tableSize;
		}
		return false;
	}

	private int hash(int key) {
		int hk = key % tableSize;
		System.out.println("hk " + hk);
		return hk;
	}
	
	public void deleteLinear(int key) {
		int index = hash(key);
		int originalIndex = index;
		int i = 0;

		while (table[index] != -1) {
			if (table[index] == key) {
				table[index] = -1;
				return;
			}
			index = (originalIndex + i++) % tableSize;
		}
	}
	
	
	public void insertQuadratic(int key) {
		int index = hash(key);
		int i = 0;
		while (table[(index + i * i) % tableSize] != -1) {
			i++;
		}
		table[(index + i * i) % tableSize] = key;
	}
	
	public boolean searchQuadratic(int key) {
		int index = hash(key);
		int i = 0;
		while (table[(index + i * i) % tableSize] != -1) {
			if (table[(index + i * i) % tableSize] == key) {
				return true;
			}
			i++;
		}
		return false;
	}

	public void deleteQuadratic(int key) {
		int index = hash(key);
		int i = 0;
		while (table[(index + i * i) % tableSize] != -1) {
			if (table[(index + i * i) % tableSize] == key) {
				table[(index + i * i) % tableSize] = -1;
				return;
			}
			i++;
		}
	}
	
	
	public int universalHash(int key) {
		return ((a * key + b) % p) % tableSize;
	}

	public void insertUniversal(int key) {
		int index = universalHash(key);
		int originalIndex = index;
		int i = 0;
		while (table[index] != -1) {
			index = (originalIndex + i++) % tableSize;
		}
		table[index] = key;
	}
	
	public boolean searchUniversal(int key) {
		int index = universalHash(key);
		int originalIndex = index;
		int i = 0;
		while (table[index] != -1) {
			if (table[index] == key)
				return true;
			index = (originalIndex + i++) % tableSize;
		}
		return false;
	}

	public void deleteUniversal(int key) {
		int index = universalHash(key);
		int originalIndex = index;
		int i = 0;

		while (table[index] != -1) {
			if (table[index] == key) {
				table[index] = -1;
				return;
			}
			index = (originalIndex + i++) % tableSize;
		}
	}


public void displayHashTable() {
    System.out.print("Hash Table: ");
    for (int i = 0; i < tableSize; i++) {
        System.out.print("[" + i + "]=" + table[i] + "  ");
    }
    System.out.println();
}
}

public class HashDemo {

	public static void main(String[] args) {
		int size = 7;
		HashTable ht = new HashTable(size);
		ht.display();
		
		ht.insertLinear(10);
		ht.insertLinear(20);
		ht.insertLinear(30);
		ht.insertLinear(40);
		ht.insertLinear(50);
		ht.insertLinear(60);
		ht.insertLinear(70);
		ht.deleteLinear(40);
		ht.insertLinear(80);
		
		ht.display();
		
		System.out.println(ht.searchLinear(30));
		
		System.out.println("Quadratic Probing");
		HashTable htq = new HashTable(size);
		htq.insertQuadratic(10);
		htq.insertQuadratic(20);
		htq.insertQuadratic(30);
		htq.insertQuadratic(40);
		htq.insertQuadratic(50);
		htq.insertQuadratic(60);
		htq.insertQuadratic(70);
		//htq.insertQuadratic(80);
		htq.display();
		
		System.out.println("Search 70 " + htq.searchQuadratic(70));
		htq.deleteQuadratic(40);
		htq.display();

		System.out.println(ht.isPrime(13));
		System.out.println("Universal Hashing...");
		HashTable htu = new HashTable(size);
		htu.insertUniversal(10);
		htu.insertUniversal(20);
		htu.insertUniversal(30);
		htu.insertUniversal(40);
		htu.insertUniversal(50);
		htu.insertUniversal(60);
		htu.insertUniversal(70);
		
		htu.display();
		System.out.println("Search 20 " + htu.searchUniversal(20));
		System.out.println("After Delete");
		htu.deleteUniversal(70);
		htu.display();
		htu.displayHashTable();
		
	}

}
