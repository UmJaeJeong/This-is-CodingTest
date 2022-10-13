import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> s = new Stack<>();
        
        for(int n : arr){
            if(s.isEmpty()){
                s.add(n);
                continue;
            }
            
            if(s.peek() != n){
                s.add(n);
            }
        }
        
        answer = new int[s.size()];
        for(int i=s.size()-1; i>=0;i--){
            answer[i] = s.pop();
        }

        return answer;
    }
}
