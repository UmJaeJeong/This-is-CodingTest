import java.util.*;
class Solution {
    List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        list = new List[n+1];
        for(int i=0; i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        for(int[] wire : wires){
            int n1 = bfs(wire[0],wire[1],n);
            int n2 = bfs(wire[1],wire[0],n);
            
            answer = Math.min(answer,Math.abs(n1-n2));
        }
        return answer;
    }
    
    public int bfs(int v1, int v2, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        int cnt = 0;
        
        q.add(v1);
        visited[v1] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            
            for(int next : list[cur]){
                if(next != v2 && !visited[next]){
                    q.add(next);
                    visited[next]= true;
                }
                
            }
        }
        return cnt;
    }
}
