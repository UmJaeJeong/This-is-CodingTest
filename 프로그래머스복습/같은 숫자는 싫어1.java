import java.util.*;
//2) Stack을 이용한는방법?
//3) Queue를 이용하는 방법?
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        //Stack에 값을 넣으며 이전에 넣었던 값과 비교 후 동일 할경우 Pass
        for(int a : arr){
            if(stack.isEmpty()){
                stack.push(a);
            }else{
                if(stack.peek()==a)continue;
                stack.push(a);
            }
        }
        
        //stack을 뺴면서 answer에 역배열순으로 값을 넣음
        answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0;i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}
