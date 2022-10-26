//좋은문제
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //트럭을 담는 Q
        Queue<Integer> truck_q = new LinkedList<>();
        //다리역할 Q
        Queue<Integer> bridge_q = new LinkedList<>();
        //누적된 다리의 무게 저장
        int stock_weight = 0;
        
        for(int t : truck_weights){
            truck_q.add(t);
        }
        
        for(int i=0; i<bridge_length;i++){
            bridge_q.add(0);
        }
        
        //대기트럭이 없을때까지 반복
        while(!truck_q.isEmpty()){
            int cur_w = truck_q.peek()-bridge_q.peek();
            int sum = stock_weight+cur_w;
             //누적된 다리무게 + 다음 트럭의 무게가 버틸수 있는 무게일 경우
            if(sum<=weight){
                stock_weight+=cur_w;
                bridge_q.add(truck_q.poll());
                bridge_q.poll();
            }else{//누적된 다리무게 버티지 못할 경우
                stock_weight-=bridge_q.poll();
                bridge_q.add(0);
            }
            answer++;
        }
       
                
        return answer+bridge_length;
    }
}
