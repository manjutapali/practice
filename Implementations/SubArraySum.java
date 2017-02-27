public class SubArraySum
{
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int res = 0;
        int n = arr.length;
        // Generating sub array and adding them
        for(int i = 0; i < n; ++i)
        {
            for(int j = i; j < n; j++)
            {
                for(int k = i; k <= j; k++)
                {
                    res += arr[k];
                }
            }
        }

        System.out.println("Sub array sum  = " + res);
    }
}
