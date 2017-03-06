/*
  Given 'n' number of times, calculate angle covered by
  hour, minute, second hand btwn i & i-1 time.
  Time is in 24hrs format
*/
import java.util.Scanner;
public class ClockAngles
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String time[] = new String[N];

        for(int i = 0; i < N; i++)
        {
            time[i] = in.next();
        }

        GetAngleCovered(time, N);

    }

    static void GetAngleCovered(String time[], int N)
    {
        for(int i = 1; i <= N - 1; i++)
        {
            int h1 = Integer.parseInt(time[i-1].substring(0,2));
            int m1 = Integer.parseInt(time[i-1].substring(3,5));
            int s1 = Integer.parseInt(time[i-1].substring(6,8));

            int h2 = Integer.parseInt(time[i].substring(0,2));
            int m2 = Integer.parseInt(time[i].substring(3,5));
            int s2 = Integer.parseInt(time[i].substring(6,8));

            int s = s2 - s1;
            int m = 0;
            int h = 0;
            if(s < 0)
            {
                //System.out.print("sbjabsjf");
                s = 60 + s;
                m2--;
            }
            if(m2 < 0)
            {
                h2--;
                m2 = 60 + m2;
            }
            m = m2 - m1;
            if(m < 0)
            {
                m = 60 + m;
                h2++;
            }
            h = h2 - h1;
            if(h < 0)
                h = -h;
            System.out.println("Time is = " + h + ":" + m + ":" + s);
            double tot_sec = h * 3600 + m * 60 + s;

            System.out.println("Total seconds = " + tot_sec);

            double sec_h = tot_sec * 360 / 60;
            System.out.print(sec_h / 60 / 24);
            System.out.print(" "+ sec_h / 60);
            System.out.println(" "+ sec_h);
            System.out.println();
        }
    }
}
