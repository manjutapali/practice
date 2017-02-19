public class SelectionSort
{
    public static void main(String[] args) {

        int arr[] = {4,8,2,7,5,1,9};

        sort(arr);

        System.out.println("After sorting...");

        for(int i: arr)
        {
            System.out.println(i);
        }
    }

    static void sort(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            int min = i;

            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[min])
                {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
