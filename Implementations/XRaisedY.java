/*
Given a positive integer n, find if it can be expressed as
xy where y > 1 and x > 0 and x and y both are both integers.
*/

import java.util.Scanner;
public class XRaisedY
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /*for(int x = 2; x <= Math.sqrt(n); x++)
        {
            int y = 2;
            int res = (int) Math.pow(x, y);
            while( res <= n && res > 0)
            {
                if(res == n)
                {
                    System.out.println("Yes");
                    System.exit(0);
                }

                y++;
                res =(int) Math.pow(x, y);
            }
        }*/

        // Optimized
        System.out.println(IsXRaiseY(n) ? "YES" : "NO");
    }

    static boolean IsXRaiseY(int n)
    {
        if(n <= 1)
          return true;

        for(int x = 2; x <= Math.sqrt(n); x++)
        {
            int res = x;

            while(res <= n)
            {
                res *= x;
                if(res == n)
                    return true;
            }
        }

        return false;
    }
}
