/*
  Function sum,
  f(x) = 1, when x = 1;
  f(x) = 2, when x = 2;
  f(x) = 5, when x = 3;
  f(x) = 12, when x = 4;

  f(x) = f(x - 1) + 2*f(x - 2) + 3*f(x-3) + f(x-4);

 */
import java.util.*;
public class FunctionSum{

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fun(n));
    }

    static long fun(int x){
        
        long fi1 = 12;
        long fi2 = 5;
        long fi3 = 2;
        long fi4 = 1;

        long fx = 0;
        for(int i = 5; i <= x; i++){
            fx = fi4 + 2*fi2 + 3*fi3 + fi1;
            fi4 = fi3;
            fi3 = fi2;
            fi2 = fi1;
            fi1 = fx;
        }

        return fx;
    }
}
