import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Study0327 {

    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static int N;
    static int[] arr;
    static int[] tempArr;
    public static void main(String[] args) {
        //차이를 최대로
        // |a1-a2|

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            visited = new boolean[N];
            arr = new int[N];
            tempArr = new int[N];

            for(int i=0 ; i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //dfs 순열
        //완전탐색 (범위가 8까지)


        System.out.println(max);

    }

    public static void dfs(int depth) {
        if(depth==N){
            max = Math.max(max, calculate(tempArr));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempArr[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculate(int[] tempArr) {
        int result = 0;

        for (int i = 0; i < tempArr.length-1; i++) {
            result+=Math.abs(tempArr[i]-tempArr[i+1]);
        }

        return result;
    }
}
