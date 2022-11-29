import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //HashMap에 담기 (종류,갯수)
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length;i++){
            if(map.containsKey(tangerine[i])){
                int cnt = map.get(tangerine[i])+1;
                map.put(tangerine[i],cnt);
            }else{
                map.put(tangerine[i],1);
            }
        }
        //갯수가 많은순으로 오름차순
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,(o1,o2)->{
           return o2.compareTo(o1);
        });
        
        //조합으로 찿기
        for(int i=0; i<list.size();i++){
            k-=list.get(i);
            answer++;
            if(k<=0)break;
            
            
        }
        return answer;
    }
}
