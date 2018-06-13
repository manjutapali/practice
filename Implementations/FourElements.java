import java.util.*;

public class FourElements {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T > 0) {
		    
		    int N = in.nextInt();
		    int arr[] = new int[N];
		    
		    for(int i = 0; i < N; i++) {
		        
		        arr[i] = in.nextInt();
		    }
		    
		    int sum = in.nextInt();
		    
		    System.out.println(IsSumExist(arr, N, sum));

		    T--;
		}		
	}

	private static int IsSumExist(int arr[], int N, int sum) {

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < N - 1; i++) {

			for(int j = i+1; j < N; j++) {

				int ele_sum = arr[i] + arr[j];

				int diff = sum - ele_sum;

				if(set.contains(diff))
					return 1;
			}

			for(int k = 0; k < i; k++) {
				set.add(arr[i] + arr[k]);
			}
		}


		return 0;
	}
}