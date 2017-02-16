public class MaxSumSubArray{

    public static void main(String[] args) {

        int a[] = {-2, -3, -4, -1, -2};

        System.out.println(getMaxSum(a));
    }

    static int getMaxSum(int arr[]){

        int max_curr = arr[0];
        int max_glob = arr[0];
        int i = 1;
        int st = 0;
        int end = 0;
        int start = 0;
        while(i < arr.length){

            max_curr = Math.max(arr[i], arr[i] + max_curr);
            if(max_curr == arr[i]){
              st = i;
            }
            if(max_glob < max_curr){
                max_glob = max_curr;
                start = st;
                end = i;
            }

            i++;
        }

        System.out.println("start = " + start);
        System.out.println("end = " + end);

        return max_glob;
    }
}
