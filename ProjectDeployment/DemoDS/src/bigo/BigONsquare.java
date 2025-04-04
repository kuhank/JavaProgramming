package bigo;

public class BigONsquare {

	public static void main(String[] args) {
		int n = 5, sum = 0;
		for (int i = 1; i <= n; i++) {					//O(n)
			System.out.println("i -- " + i);
			for (int j = 1; j <= n; j++) {				//O(n)
				System.out.println("j -- " + j);
				
				sum += i;
			}

		}
		System.out.println("Sum = " + sum);
	}
}
//O(n) * O(n) = O(n^2)