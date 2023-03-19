package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_4 {
    static int N;
    static int M;

    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) {


        //같은수를 여러번 골라도됨
        //비내림차누이어야함 오름차순? <=
        //선언 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        //N, M입력

        try {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[M];

            //dfs 탐색(백트래킹)
            dfs(0,1);

            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //백트래킹 dfs 같은 값을 가져도 됨
    public static void dfs(int depth, int start) {
        //M개의 값을 가질대 탈출
        if (depth == M) {
            for(int i=0; i<M;i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        //0~N까지 탐색
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth+1,i);
        }
    }
}
