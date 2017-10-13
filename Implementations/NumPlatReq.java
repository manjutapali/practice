import java.util.Arrays;

public class NumPlatReq
{

    public static void main(String[] args)
    {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        NumPlatReq n = new NumPlatReq();
        System.out.println("Number of platforms req = " + n.getNumPlat(arr, dep));
    }

    public int getNumPlat(int arr[], int dep[])
    {
        sort(arr);
        sort(dep);
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

    // quick sort
    public void sort(int arr[])
    {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int arr[], int low, int high)
    {
        if(low < high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int arr[], int l, int h)
    {
        int i = l - 1;
        int p = arr[h]; // pivot

        for(int j = l; j < h; j++)
        {
            if(arr[j] < p)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[h];
        arr[h] = arr[i+1];
        arr[i+1] = temp;

        return i + 1;
    }
}
