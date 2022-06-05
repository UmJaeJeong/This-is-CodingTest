package Sort;

import java.util.*;

public class 두배열의원소교체 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        for(int i=0; i<N;i++){
            A[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i=0; i<N;i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());

        for(int i=0; i<K;i++){
            if(A[i]<B[i]){
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            }else break;
        }
        int sum= 0;
        for(int i=0; i<N;i++){
            sum+=A[i];
        }

        System.out.println(sum);

    }
}
