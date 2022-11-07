import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int maxNum = n;
        int cycle = 1;
        int idx = 1;
        //몇바퀴 일때?
        //몇번째 사람이?
        
        Set<String> repeatCheck = new  HashSet<>();
        for(int i=1; i<words.length;i++){
            repeatCheck.add(words[i-1]);
            if(idx==maxNum){
                idx=1;
                cycle++;
            }else{
                idx++;
            }
            //이전 단어의 끝 글자
            String end = String.valueOf(words[i-1].charAt(words[i-1].length()-1));
            //현재 단어의 첫 글자
            if(!words[i].startsWith(end) || repeatCheck.contains(words[i])){
                answer[0] = idx;
                answer[1] = cycle;
                return answer;
            }
            
        }

        return answer;
    }
}
