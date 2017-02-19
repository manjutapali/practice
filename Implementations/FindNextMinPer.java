/*
    Given number find the next greater min number
    eg:
      Given - 1234
      next min - 1243

      approach:
      1. If digits are in descending order "not possible";
      2. If digits are in ascending order swap last two digits;
      3. From the right side of number find smallest digit
          eg: for 46376
          from right side (6 - 3), 3 is smallest digit.
          swap 3 with 6, then num will be 46673
          sort the next digits, will get 46637
*/
import java.util.Scanner;

public class FindNextMinPer
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();

        String num = in.next();

        System.out.println("Next greater Number");
        System.out.println(getNextGrNum(num));

    }

    static String getNextGrNum(String num)
    {
        if(num.length() == 1 || num == null)
            return num;
        char n[] = num.toCharArray();
        int len = num.length();
        char last = n[len-1];
        int i = len - 2;
        while(i >= 0)
        {
            if(last > n[i])
            {
                break;
            }
            i--;
        }

        //swapping
        if(i == -1){

            System.out.println("Cannot be found");
            return num;
        }
        char c = n[len-1];
        n[len-1] = n[i];
        n[i] = c;
        //sort from i
        for(int j = i + 1; j < len; j++)
        {
            int min = j;
            for(int k = j + 1; k < len; k++)
            {
                if(n[min] > n[k])
                    min = k;
            }

            char temp = n[min];
            n[min] = n[j];
            n[j] = temp;

        }

        return new String(n);
    }
}
