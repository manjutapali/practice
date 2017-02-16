public class QuickSort{
    public static void main(String[] args) {

        int arr[] = {4,8,1,2,4,9,5,7};

        sort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }
    }

    static void sort(int arr[], int l, int h){

        if(l < h){

            int pi = partition(arr, l, h);

            sort(arr, l, pi-1);
            sort(arr, pi+1, h);
        }
    }

    static int partition(int arr[], int l, int h){

        int i = l-1;
        int p = arr[h];

        for(int j = l; j <= h-1; j++){

            if(arr[j] < p){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return i+1;
    }
}
