/*
        
Given an unsorted array. The task is to find all the star and super star elements in the array. Star are those elements which are strictly greater than all the elements on its right side. Super star are those elements which are strictly greater than all the elements on its left and right side.

Note: Assume first element (A[0]) is greater than all the elements on its left side, And last element (A[n-1]) is greater than all the elements on its right side.

*/
import java.util.Scanner;
import java.util.Arrays;

public class StarElements {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while(T > 0) {

			int N = in.nextInt();

			int arr[] = new int[N];

			for(int i = 0; i < N; i++) {

				arr[i] = in.nextInt();
			}

			PrintStarElements(arr, N);

			T--;
		}
	}

	private static void PrintStarElements(int arr[], int N) {

		int R[] = new int[N];
		int L[] = new int[N];

		int max = Integer.MIN_VALUE;

		for(int i = N - 1; i >= 0; i--) {

			if(arr[i] > max) {
				R[i] = arr[i];
				max = arr[i];
			}
		}

		max = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++) {

			if(arr[i] > max) {
				L[i] = arr[i];
				max = arr[i];
			}
		}

		System.out.println(Arrays.toString(L));
		System.out.println(Arrays.toString(R));

		int ss_idx = -1;

		for(int i = 0; i < N; i++) {

			if(R[i] != 0) {
				System.out.print(arr[i] + " ");
			}

			if(L[i] != 0 && L[i] == R[i]) {
				ss_idx = i;
			}
		}
		System.out.println();

		System.out.println((ss_idx == -1) ? "-1" : arr[ss_idx]);
	}
}

/*
	Better approach to use stack, push the elements from right side of the array only if it's greater than peek. The top element will be always super star. But, need to fix if there are equal elements, where super star will be -1.
*/