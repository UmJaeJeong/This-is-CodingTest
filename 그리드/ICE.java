package dfsbfs;
import java.util.*;

public class ICE {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy ={1,-1,0,0};

    public static int answer =0;
    public static int N, M;

    public static int[][] graph;
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = 4;
        M = 5;
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N;i++){
            String str = sc.nextLine();
            for(int j=0;j<M;j++){
             graph[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && graph[i][j]==0){
                    dfs(i,j);
                    answer++;
                }
            }
        }
        System.out.println("answer : "+answer);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(!visited[nx][ny] && graph[nx][ny]==0){
                    dfs(nx,ny);
                }
            }
        }
    }

}
