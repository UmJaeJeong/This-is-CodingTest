//다시풀기
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String p : participant){
            if(map.containsKey(p)){
                map.put(p,map.get(p)+1);
            }else{
                map.put(p,1);
            }
        }
        
        for(String c : completion){
            int count = map.get(c)-1;
            if(count ==0){
                map.remove(c);
                continue;
            }
            map.put(c,count);
        }
        
        for(String key : map.keySet()){
            answer = key;
        }
        return answer;
    }
}
