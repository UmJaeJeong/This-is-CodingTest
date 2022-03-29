import java.util.*;


public class GameDevelop {

    static int n, m, x, y, direct;

    static int[][] visited = new int[50][50];

    static int[][] map = new int[50][50];

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void turnLeft(){
        direct--;
        if(direct==-1)direct=3;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //N, M 공백기준 데이터 받기
          n = sc.nextInt();
          m = sc.nextInt();

          //현재 캐릭터 좌표와 방향 받기
        x = sc.nextInt();
        y = sc.nextInt();
        direct = sc.nextInt();

        visited[x][y] = 1; //현재 좌표 방문처리

        //전체맵 정보 받기
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        //시뮬레이션 시작
        int cnt  = 1;
        int turn_time = 0;

        while(true){
            //왼쪽으로 회전
            turnLeft();
            int nx = x+dx[direct];
            int ny = y+dy[direct];

            //회전한 후 가보지않은 칸이 있으면 가보기
            if(map[nx][ny]==0 && visited[nx][ny]==0){
                x = nx;
                y = ny;
                cnt++;
                turn_time=0;
                continue;
            }else{//회전한 후 가보지 않은 칸이 없거나 막혀 있는 경우
                turn_time++;
            }

            if(turn_time==4){ //회전 4번을 다했을 경우
                nx = x-dx[direct];
                ny = y-dy[direct];
                if(map[nx][ny]==0) {
                    x = nx;
                    y = ny;
                    turn_time = 0;
                }else{
                    break;
                }
            }
        }

        System.out.println(cnt);

    }


}
