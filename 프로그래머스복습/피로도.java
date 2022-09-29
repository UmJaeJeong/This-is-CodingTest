class Solution {
    
    boolean[] visited;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return max;
    }
    
    public void dfs(int k, int[][] dungeons, int clearCnt){
        for(int i=0; i<dungeons.length;i++){
            
            if(!visited[i] && k>=dungeons[i][0]){
                
                visited[i] = true;
                dfs(k-dungeons[i][1],dungeons,clearCnt+1);
                visited[i] = false;
            }
        }
        max = Math.max(max, clearCnt);
    }
}
