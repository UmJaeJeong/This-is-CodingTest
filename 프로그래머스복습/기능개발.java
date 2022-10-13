import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length;i++){
            int remainDays = (int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            if(!q.isEmpty() && q.peek()<remainDays){
                list.add(q.size());
                q.clear();
            }
            q.offer(remainDays);
        }
        list.add(q.size());
        
        answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
