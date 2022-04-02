package dfsbfs;
import java.util.*;

public class MaseEscape {

    private static int N, M;

    private static int[][] map;

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        sc.nextLine();
        for(int i=0; i<N;i++){
            String input = sc.nextLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y){
        Queue<MaseNode> q = new LinkedList<MaseNode>();
        q.offer(new MaseNode(x,y));

        while(!q.isEmpty()){
            MaseNode node = q.poll();
            x = node.x;
            y = node.y;

            for(int i=0; i<4;i++){
                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(map[nx][ny] ==1){
                        map[nx][ny] = map[x][y]+1;
                        q.offer(new MaseNode(nx,ny));
                    }
                }
            }
        }


    }
}

class MaseNode{
    int x,y;

    public MaseNode(int x, int y){
        this.x = x;
        this.y = y;
    }
}
