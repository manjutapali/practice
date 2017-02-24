// Given number n, count smaller numbers that are XOR with n to give greater number than n
import java.util.Scanner;
public class CountSmallerNum
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(GetNumbersCount(n));
    }

    static int GetNumbersCount(int n)
    {
        int count = 0;
        int k = 0;

        while(n > 0)
        {
            if((n&1) == 0)
            {
                count += Math.pow(2, k);
            }

            k += 1;
            n >>= 1;
        }
        return count;
    }
}
