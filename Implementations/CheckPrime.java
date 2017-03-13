import java.util.Scanner;
public class CheckPrime
{

    public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();

      boolean flag = isPrime(n);
      System.out.println(flag ? "YES": "NO");
    }

    public static boolean isPrime(int n)
    {
        for(int i = 2; i <= n/2; i++)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
