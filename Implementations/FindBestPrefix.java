/*
  Given numbers x, y and an array. Find the longest prefix which contain equal number of x and y, return -1 if there is no prefix
*/

public class FindBestPrefix
{
    public static void main(String[] args)
    {
        int x = 10;
        int y = 40;
        int arr[] = {100,10,20,50,40,10,20,75,79,40};

        int nx = 0, ny = 0;
        int result = - 1, startidx = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == x)
                nx++;
            if(arr[i] == y)
                ny++;

            if((nx != 0 || ny != 0) && (startidx == -1) )
                startidx = i;
            if(nx == ny && nx != 0)
                result = i;
        }

        System.out.println(result - startidx);
    }
}
