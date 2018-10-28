import java.util.Scanner;
import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []arr = new int[n];

		for (int i = 0; i < n ; ++i) {
			arr[i] = in.nextInt();
		}

		HeapSort hs = new HeapSort();
		hs.sort(arr);

		System.out.println(Arrays.toString(arr));
	}

	private void heapify(int arr[], int i, int n) {

		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if ( l < n && arr[largest] < arr[l] )
			largest = l;

		if ( r < n && arr[largest] < arr[r] )
			largest = r;

		if ( largest != i ) {
			int t = arr[i];
			arr[i] = arr[largest];
			arr[largest] = t;

			heapify(arr, largest, n);
		}
	}

	public void sort(int arr[]) {
		int len = arr.length;

		// construct heap
		for (int i = len/2-1; i >= 0 ; i--) {
			heapify(arr, i, len);
		}

		// extract max and place at the end (swap with end and heapify)
		for (int i = len-1; i >= 0; i--) {
			int t = arr[i];
			arr[i] = arr[0];
			arr[0] = t;

			heapify(arr, 0, i);			
		}
	}
}