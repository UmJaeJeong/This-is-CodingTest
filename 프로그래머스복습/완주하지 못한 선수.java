import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //제한사항 주의 동명이인이 있음)
        
        //후보자들을 모두 map에 담는다.(key = 후보자명 , value = 인원(동명이인 체크위해))
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;  i<participant.length;i++){
            if(map.containsKey(participant[i])){
                map.put(participant[i],map.get(participant[i])+1);
               
            }else{
                map.put(participant[i],1);
            }
            
        }
        
        // 완주한 사람의 후보자명으로 map에서 검색 후 완주 여부를  넣는다(감소하면 인원이 줄어듦)
        for(String s : completion){
            int n= map.get(s)-1;
            map.put(s,n);
        }
        
        //모든 후보자들 중 완주하지  못한 사람을 골라낸다.
        for(String s: map.keySet()){
            if(map.get(s)!=0){
                answer = s;
                break;
            }
            
        }
        return answer;
    }
}
