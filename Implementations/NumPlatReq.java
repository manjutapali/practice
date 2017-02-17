import java.util.Arrays;

public class NumPlatReq
{

    public static void main(String[] args)
    {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Number of platforms req = " + getNumPlat(arr, dep));
    }

    public static int getNumPlat(int arr[], int dep[])
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(dep));
        int max_plat_need = 1, plat_need = 1;
        int i = 1, j = 0;
        int n = arr.length;

        while(i < n && j < n)
        {
            if(arr[i] < dep[j])
            {
                i++;
                plat_need++;

                if(max_plat_need < plat_need)
                {
                    max_plat_need = plat_need;
                }
            }
            else
            {
                j++;
                plat_need--;
            }
        }

        return max_plat_need;
    }
}
