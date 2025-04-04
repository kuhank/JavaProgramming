package bigo;

public class BigOLogn {

	public static void main(String[] args) {
		int  n= 500000;
		int count = 0;
		
		for(int i=n ; i >1 ; i /= 2) {
			System.out.println("i " + i);
			count ++ ;
		}
		System.out.println("Count = " + count);
	}

}
