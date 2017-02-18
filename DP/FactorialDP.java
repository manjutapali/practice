import java.util.Scanner;

public class FactorialDP
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int st[] = new int[n+1];

        int fact = getFact(n , st);

        System.out.println(fact);
    }

    static int getFact(int n, int st[])
    {
        if(n == 0 || n == 1)
            return 1;
        else{

            if(st[n] != 0)
                return st[n];
            else{

                return st[n] = (n * getFact(n-1, st));
            }
        }
    }
}
