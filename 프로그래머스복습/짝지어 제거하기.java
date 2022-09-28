import java.util.*;
class Solution
{

    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> set = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.isEmpty()&&ch==set.peek()){
                set.pop();
            }else{
                set.push(ch);
            }
        }
        if(set.size()==0)answer = 1;
        
        return set.isEmpty()?1:0;
    }
}
