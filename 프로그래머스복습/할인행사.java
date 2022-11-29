import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //set으로 컨버트
        Map<String, Integer> map = new HashMap<>();
        
         //discount-10만큼 반복
        for(int j=0; j<discount.length-9;j++){
            //값 초기화
            for(int i=0; i<want.length;i++){
                map.put(want[i],number[i]);
            }
            //10번 반복
            for(int k=j;k<j+10;k++){
                if(map.containsKey(discount[k])){
                    int cnt = map.get(discount[k])-1;
                    if(cnt==0)map.remove(discount[k]);
                    else map.put(discount[k],cnt);
                }
            }
            //map이 empty일때 결과값 도출
            if(map.isEmpty())answer++;
        }
                   
        
        return answer;
    }
}

///총일수를 반환
