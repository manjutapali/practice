import java.util.HashSet;

public class DuplicateKthIndex
{
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,2,4,7,2};
		int k = 3;
		DuplicateKthIndex d = new DuplicateKthIndex();

		System.out.println(d.IsDuplicateExistKthIndex(arr, arr.length, k) ? "YES" : "NO");
	}

	public boolean IsDuplicateExistKthIndex(int arr[], int N, int k)
	{
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < N ; i++) 
		{
			if(set.contains(arr[i]))
				return true;

			if(i >= k)
				set.remove(arr[i-k]);

			set.add(arr[i]);		
		}

		return false;
	}


}

