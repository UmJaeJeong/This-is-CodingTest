package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_3 {
    static int N;
    static int M;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;


    public static void main(String[] args) {
        //1~N까지 자연수중 M개를 선택하는 수열
        //같은수를 여러번 골라도 괜찮다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            //입력
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M];

            //dfs탐색
            dfs(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);

    }



    //dfs
    public static void dfs(int depth) {
        //탈출
        if (depth == M) {
            for (int k : arr) {
                sb.append(k).append(' ');
            }
            sb.append('\n');
            return;
        }

        //반복하며 탐색, 중복가능
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }

    }
}
