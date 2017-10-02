/*
	* 0/1 knapsack problem.

*/

public class Knapsack 
{

	public static void main(String[] args) 
	{	
		int wt[] = {10, 20, 30};
		int val[] = {60, 100, 120};

		// System.out.println(DynamicKS(wt, val, 50));
		System.out.println(RecurKS(wt, val, 50, 3));
	}

	public static int RecurKS(int wt[], int val[], int maxWght, int n)
	{
		if(n == 0 || maxWght == 0)
			return 0;

		if(wt[n - 1] > maxWght)
			return RecurKS(wt, val, maxWght, n - 1);
		else
			return Math.max(val[n - 1] + RecurKS(wt, val, maxWght - wt[n - 1], n - 1), RecurKS(wt, val, maxWght, n - 1));
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