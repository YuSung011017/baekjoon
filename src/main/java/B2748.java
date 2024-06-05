import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748 {
    static int n;
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr = new long[91];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }


        System.out.println(arr[n]);
    }

}
