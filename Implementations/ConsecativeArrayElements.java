/*
	* check if elements are consecative in an unsorted array.
	
	Methods:
	1. sort and check for consecative, arr[i - 1] - arr[i] = 1;
	
	2. max - min + 1 = n, max and min element in array, n - number of elements.
	   check if all elements are distinct.
*/

public class ConsecativeArrayElements
{
	public static void main(String[] args)
	{
		int arr[] = {14, 15, 19, 17, 16, 18};

		ConsecativeArrayElements obj = new ConsecativeArrayElements();

		System.out.println(obj.CheckIsConsecative(arr));
	}

	public boolean CheckIsConsecative(int arr[])
	{
		int min = GetMinEle(arr);
		int max = GetMaxEle(arr);

		if((max - min + 1) == arr.length)
		{
			boolean v[] = new boolean[arr.length];

			for(int i = 0; i < arr.length; i++)
			{
				if(v[arr[i] - min] == true)
					return false;

				v[arr[i] - min] = true;
			}

			return true;
		}

		return false;
	}

	public int GetMinEle(int arr[])
	{
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++)
			if(arr[i] < min)
				min = arr[i];

		return min;		
	}

	public int GetMaxEle(int arr[])
	{
		int max = Integer.MIN_VALUE;

		for(int j = 0; j < arr.length; j++)
			if(arr[j] > max)
				max = arr[j];

		return max;	
	}
}

