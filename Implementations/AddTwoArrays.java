/*
	* Given arrays representing the numbers, 
	* add them to get the resultant array
*/

public class AddTwoArrays
{
	public static void main(String[] args) 
	{
		int num1[] = new int[]{9,1,2,3};
		int num2[] = new int[]{1,0,0,0};

		AddTwoArrays obj = new AddTwoArrays();
		
		int sum[] = obj.GetAdditionResult(num1, num2);
		int i = 0;
		if(sum[0] == 0)
			i = 1;

		for(int j = i; j <= sum.length - 1; j++)
		{
			System.out.print(sum[j]);
		}
		System.out.println();	
	}

	public int[] GetAdditionResult(int num1[], int num2[])
	{
		int maxLen = Math.max(num1.length, num2.length);
		int sum[] = new int[maxLen + 1];
		int k = maxLen;
		int i = num1.length - 1;
		int j = num2.length - 1;
		int c = 0;
		int add = 0;
		
		while(i >= 0 && j >= 0)
		{
			add = num1[i--] + num2[j--] + c;
			c = add / 10;
			sum[k--] = add % 10;
		}

		while(i >= 0)
		{
			add = num1[i--] + c;
			c = add / 10;
			sum[k--] = add % 10;
		}

		while (j >= 0) 
		{
			add = num2[j--] + c;
			c = add / 10;
			sum[k--] = add % 10;	
		}

		if( c != 0)
		{
			sum[0] = c;
		}

		return sum;
	}
}