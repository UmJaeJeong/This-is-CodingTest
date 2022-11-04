//다시풀기
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        //글자 모두 소문자로 변경
        s = s.toLowerCase();
        char start = ' ';
        
        //s의 첫글자 전비교값을 '공백'으로 하면서 단어일경우 앞부분을 대문자로 변경
        for(int i=0; i<s.length();i++){
            if(i!=0)start = s.charAt(i-1);
            char c = s.charAt(i);
            if(start==' ' && s.charAt(i)>='a' && s.charAt(i)<='z'){
                answer+=String.valueOf(c).toUpperCase();
            }else{
                answer+=String.valueOf(c);
            }
        }
        return answer;
    }
}
