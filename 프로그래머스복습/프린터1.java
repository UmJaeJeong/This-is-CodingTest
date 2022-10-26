//다시풀기
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length;i++){
            q.add(new Pair(i,priorities[i]));
        }
        
        while(!q.isEmpty()){
            int current = q.peek().value;
            boolean flag = false;
            for(Pair pair : q){
                if(pair.value>current){
                    flag = true;
                    break;
                }
            }
            if(flag){
                Pair tmp = q.poll();
                q.add(tmp);
            }else{
                answer++;
                Pair pair = q.poll();
                if(pair.index == location) return answer;
            }
        }
        return answer;
    }
    
    class Pair{
        int index;
        int value;
        
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
