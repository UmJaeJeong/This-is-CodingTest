class Solution {
    String direct = "ULDR";
    int[] dx = {0,-1,0,1};
    int[] dy = {1,0,-1,0};
    
    public int solution(String dirs) {
        int answer = 0;
        
        //시작점이 5,5
        //왼쪽 하단이 0,0
        //오른쪽 상단이 10,10으로 가정
        int map[][] = new int[11][11];
        boolean visited[][][] = new boolean[11][11][4];
        int x=5;
        int y= 5;
        
        for(int i=0; i<dirs.length();i++){
            int nx = x+dx[direct.indexOf(dirs.charAt(i))];
            int ny = y+dy[direct.indexOf(dirs.charAt(i))];
            
            int d = direct.indexOf(dirs.charAt(i));
            if(nx>=0 && ny>=0 && nx<11 && ny<11){
                if(!visited[nx][ny][d]){
                    visited[nx][ny][d] = true;
                    d = (d%2 ==0)?2-d:4-d;
                    visited[x][y][d] = true;
                    answer++;
                }
                x = nx;
            y = ny;
            }
            
        }
        
        return answer;
    }
}
