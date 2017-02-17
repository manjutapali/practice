/*
  Given array of 1's and 0's, find indexes of zeroes to be flipped to get max continous sub-array containing 1's
  allowed to flip only m number of zeroes
*/
public class FindZeroesToFlip
{

    public static void main(String[] args)
    {
        int a[] = {1,0,0,0,1,1,1,0,0,1,0,1,1,0};
        int m = 2;

        PrintZeoresToflip(a,m);
    }

    public static void PrintZeoresToflip(int a[], int m)
    {
        int zc = 0, WS = 0, WL = 0; // WS - best window start, WL - window length, zc - zero count
        int LW = 0, RW = 0; // LW - left index of  window, RW - Right index of window

        while(RW < a.length)
        {
            if(zc <= m)
            {
                if(a[RW] == 0)
                    zc++;
                RW++;
            }

            if(zc > m){
                if(a[LW] == 0)
                    zc--;
                LW++;
            }

            if(RW - LW > WL){
                WL = RW - LW;
                WS = LW;
            }
        }
        System.out.println("Window Lenght = " + WL);
        System.out.println("indices of zeoes to be flipped : ");
        for(int i = 0; i< WL; i++){
            if(a[WS+i] == 0){
              System.out.print(WS + i + ", ");
            }
        }
    }
}
