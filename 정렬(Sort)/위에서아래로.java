package Sort;
import java.util.*;

public class 위에서아래로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //케이스 개수
        int N = sc.nextInt();

        Integer[] arr = new Integer[N];

        for(int i=0; i<N;i++){
            arr[i] = sc.nextInt();
        }

        //기본 정렬 라이브러리를 이용하여 내림차순 정렬 수행
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<N;i++){
            System.out.println(arr[i]+" ");
        }

    }

}
