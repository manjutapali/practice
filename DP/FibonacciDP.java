import java.util.*;
public class FibonacciDP{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n");
        int n = in.nextInt();
        fibDP(n);
    }

    static void fibDP(int n){

        int f[] = new int[n];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        for(int i = 0; i < n; i++){
            System.out.print(f[i] + ", ");
        }
        System.out.println();
    }
}
