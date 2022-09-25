import java.util.*;


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        //1) Set에 0을 제외한 값 넣기
        Set<Integer> setLottos = new HashSet<>();
        for(int i=0; i<lottos.length;i++){
            if(lottos[i]!=0)setLottos.add(lottos[i]);
        }
        
        //일치하는 갯수 체크
        int correctCnt = 0;
        //안보이는 번호 갯수 체크
        int blindCnt = 6-setLottos.size();
        //2) 보이는 값 중 일치 하는 것이 몇개 있는지 확인
        for(int i=0; i<win_nums.length;i++){
            if(setLottos.contains(win_nums[i])) correctCnt++;
        }
        
        //7에서 맞는 갯수를 뺀수가 등수 
        //만약 값이 7이라면 6이하라면 무주건 6등
        if(7-(correctCnt+blindCnt)<6){
            answer[0] = Math.min(7-(correctCnt+blindCnt),6);
            answer[1] = Math.min(7-correctCnt,6);
        }else{
             answer[0] = 6;
             answer[1] = 6;
        }
        return answer;
    }
}
