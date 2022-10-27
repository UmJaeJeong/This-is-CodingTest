//다시풀기
//자료형과 제안사항엥서 크기를 확인 또 재확인
import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer =0;

        long sum = 0;
        for(long i=1;i<=count;i++){
            sum+=price*i;
        }
        //현재가지고 있는 금액 - (price*count)
        
        if(sum>money) answer = sum-money;
        
        return answer;
    }
}
