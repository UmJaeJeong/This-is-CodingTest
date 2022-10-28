//다시풀기
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        ArrayList<Stage> list = new ArrayList<>();
        
        for(int i=1; i<=N;i++){
            list.add(new Stage(i,0));
        }
        
        for(int i=0; i<stages.length;i++){
            if(stages[i]==N+1)continue;
            Stage stage = list.get(stages[i]-1);
            stage.cnt = stage.cnt+1;
        }
        int total = stages.length;
        for(int i=0; i<N;i++){
            Stage stage = list.get(i);
            if(stage.cnt==0)continue;
            stage.rate = (double)stage.cnt/(double)total;
            total-=stage.cnt;   
        }
        
        Collections.sort(list,(o1,o2)->{
            if(o1.rate == o2.rate) return o1.idx-o2.idx;
            if(o1.rate<o2.rate) return 1;
            return -1;
        });
        
        answer=  new int[list.size()];
        int idx = 0;
        for(Stage s : list){
            answer[idx++]=s.idx;
        }
       
        
        return answer;
    }
    
    class Stage{
        int idx;
        int cnt;
        double rate;
        
        public Stage(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
