import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
                if(q.isEmpty()){
                    answer++;
                    sum+=truck;
                    q.offer(truck);
                    break;
                }else if(q.size() == bridge_length){
                    sum-=q.poll();
                }else{
                    if(sum+truck<=weight){
                        q.offer(truck);
                        answer++;
                        sum+=truck;
                        break;
                    }else{
                        q.offer(0);
                        answer++;
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}
