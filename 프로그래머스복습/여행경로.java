import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        //사용티켓 체크
        visited = new boolean[tickets.length];
        
        //ICN을 시작으로부터 DFS탐색
        dfs("ICN",tickets,"",0);
        Collections.sort(list);
        return list.get(0).trim().split(" ");
    }
    
    //찾는 티켓의 출발점 String begin , 티켓전체 String[][] tickets, 지나치는 공항 String  arrived
    public void dfs(String begin, String[][] tickets, String arrived, int depth){
        
        for(int i=0; i<tickets.length;i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            //!사용티켓인지 체크 && 출발점이 같은지 체크
            if(!visited[i] && begin.equals(start)){
                //방문 체크, DFS탐색 (출발점이 끝점으로 ), 방문 false
                visited[i]=true;
                dfs(end,tickets,arrived+" "+start,depth+1);
                visited[i] = false;
                if(depth==tickets.length-1){
                    list.add(arrived+" "+start+" "+end);
                }
                
            }
                
        }
        
        
    }
}
