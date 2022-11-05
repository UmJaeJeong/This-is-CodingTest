//다시풀기
import java.util.*;
class Solution {
    int min = Integer.MAX_VALUE;
    
    //Long타입으로 
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        //Q에 대입
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long q1_sum = 0;
        long q2_sum = 0;
        
        for(int i=0; i<queue1.length;i++){
            q1_sum+=(long)queue1[i];
            q1.offer((long)queue1[i]);
            
            q2_sum+=(long)queue2[i];
            q2.offer((long)queue2[i]);
        }
        
        int count = 0;
        while(q1_sum!=q2_sum){
            count++;
            if(q1_sum>q2_sum){
                long value = q1.poll();
                q1_sum-=value;
                q2_sum+=value;
                q2.offer(value);
            }else{
                long value = q2.poll();
                q2_sum-=value;
                q1_sum+=value;
                q1.offer(value);
            }
            
            
            if(count>(q1.size()+q2.size())*2) return -1;
        }
        
        //최솟값이 MIN_VALUE 일 경우 -1 아닐경우 극밧 반환
        return count;
    }
}
