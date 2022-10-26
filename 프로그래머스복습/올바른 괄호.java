import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        
        // "("일 경우에 stack에 쌓기
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        //")"일 경우에 stack에서 뺴기
            //stack에 아무것도 없을 경우 false
        
        //stack에 0이라면 true
        //아니라면 false
        if(stack.isEmpty())answer = true;
        return answer;
    }
}
