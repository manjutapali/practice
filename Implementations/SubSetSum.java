import java.util.*;
public class SubSetSum{

    public static void main(String[] args) {

        int a[] = {2, 3, 5, 6, 7};
        int len = a.length;
        int pow_length =(int) Math.pow(2, len);
        int sum = -1;
        int mul = 1;
        for(int i = 0; i < pow_length; i++){
            mul = 1;
            for(int j = 0; j < len; j++){

                if((i & (1 << j)) > 0){
                    System.out.print(a[j] + ",");
                    mul *= a[j];
                  }
            }
            sum += mul;
            System.out.println();
            //System.out.println(sum);
        }

        System.out.println(sum);
    }
}
