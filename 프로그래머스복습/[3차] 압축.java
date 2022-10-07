import java.util.*;

class Solution {
     HashMap<String, Integer> map;
    public int[] solution(String msg) {
        int[] answer = {};
        
        //HashMap을 활용
        map = new HashMap<>();
        for(char c ='A';c<='Z';c++){
            map.put(String.valueOf(c),c-'A'+1);
        }
        
        //answer을 저장하는 리스트
        ArrayList<Integer> list =new ArrayList<>();
        int startin =  27;
        
        boolean flag = false;
        for(int i=0; i<msg.length();i++){
            String w = String.valueOf(msg.charAt(i));
            for(int j=i+1; j<msg.length();j++){
                String c = String.valueOf(msg.charAt(j));
                if(map.containsKey(w+c)){
                    w+=c;
                    i=j;
                    continue;
                } 
                
                list.add(map.get(w));
                map.put(w+c,map.size()+1);
               break;
            }
            if(i==msg.length()-1) list.add(map.get(w));
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i]=list.get(i);
        }
    
        return answer;
    }

}
