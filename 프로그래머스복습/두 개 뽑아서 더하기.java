import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        //Set에 데이터를 담아 중복 제거
        Set<Integer> set = new HashSet<>();
        
        //numbers의 모든 조합 구하기
        for(int i=0; i<numbers.length;i++){
            for(int j=0; j<numbers.length;j++){
                if(i!=j){
                    set.add(numbers[i]+numbers[j]);
                }
            }
        }
        answer =new int[set.size()];
        int idx = 0;
        for(int i : set){
            answer[idx++] = i;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
