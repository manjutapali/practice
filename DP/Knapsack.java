/*
	* 0/1 knapsack problem.

*/

public class Knapsack 
{

	public static void main(String[] args) 
	{	
		int wt[] = {10, 20, 30};
		int val[] = {60, 100, 120};

		System.out.println(DynamicKS(wt, val, 50));
	}

	public static int DynamicKS(int wt[], int val[], int maxWght)
	{
		int table[][] = new int[val.length + 1][maxWght + 1];

		for(int i = 0; i <= val.length; i++)
		{
			for(int j = 0; j <= maxWght; j++)
			{
				if(i == 0 || j == 0)
				{
					table[i][j] = 0;
					continue;
				}

				if(j < wt[i - 1])
				{
					table[i][j] = table[i - 1][j];
				}
				else
				{
					table[i][j] = Math.max(table[i - 1][j], val[i - 1 ] + table[i - 1][j - wt[i - 1]]);
				}
			}
		}

		return table[val.length][maxWght];
	}
}