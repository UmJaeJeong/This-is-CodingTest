import java.util.*;
class Solution {
    int SIZE = 101;
    List<Rect> rectList = new ArrayList<>();
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
                                    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[102][102];
        
        for(int i=0; i<rectangle.length;i++){
            int sx = rectangle[i][0]*2;
            int sy = rectangle[i][1]*2;
            int ex = rectangle[i][2]*2;
            int ey = rectangle[i][3]*2;
            
            for(int y=sy; y<=ey;y++){
                for(int x=sx; x<=ex;x++){
                    map[y][x] = -1;
                }
            }
            rectList.add(new Rect(sx,sy,ex,ey));
            
        }
        
        int answer = bfs(map,characterX*2,characterY*2,itemX*2,itemY*2);
        return answer;
    }
    
    public int bfs(int[][] map, int x,int  y, int tx, int ty){
        Queue<int[]> q = new LinkedList<>();
        int[] arr = {x,y,1};
        q.offer(arr);
        map[y][x] = 1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int move = p[2];
            
            if(px==tx && py== ty){
                return move/2;
            }
            
            for(int i=0; i<4;i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(map[ny][nx]<0&& isBoundary(nx,ny)){
                    map[ny][nx] = 1;
                    int[] arrr = {nx,ny,move+1};
                    q.add(arrr);
                }
            }
        }
        return -1;
    }
    
    public boolean isBoundary(int x, int y){
        for(Rect r: rectList){
            if(r.x1<x && r.y1 <y && r.x2>x && r.y2 >y)return false;
        }
        return true;
    }
    
    class Rect{
        int x1,x2,y1,y2;
        
        public Rect(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}
