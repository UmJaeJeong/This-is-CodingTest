import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        //ArrayList 전력망 대입
        for(int i=0; i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);

        }
       
        //node 1개를 선택하여 이어져 있는 노드를 끊는다.
        for(int i=0; i<wires.length;i++){
           int a = bfs(wires[i][0],wires[i][1],n);
           int b = bfs(wires[i][1],wires[i][0],n);
            answer = Math.min(answer,Math.abs(a-b));
        }
            //끊어진 상태의BFS 탐색
        return answer;
    }
    
    public int bfs(int x, int y, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;        visited[y] = true;

        int sum = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : list.get(cur)){
                if(!visited[next]){
                    sum+=1;
                    visited[next] =  true;
                    q.add(next);
                }
            }
        }
        return sum;
    }
}
