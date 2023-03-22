import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 소인수분해 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isPrime = true;

                int num = Integer.parseInt(br.readLine());

                if (num == 1) {
                    continue;
                }

                for (int j = 2; i <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    count++;
                }
            }
            System.out.println(count);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
