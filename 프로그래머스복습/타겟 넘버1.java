//다른 풀이 방법에서 DFS를하여 값을 return하는 방법 참고
import java.util.*;

class Solution {
    int answer=0;
    public int solution(int[] numbers, int target) {
        //DFS 문제
        //dfs(numbers, target, depth, sum)
        dfs(numbers,target,0,0);
        return answer;
    }
    
    //dfsMethod
    public void dfs(int[] numbers, int target, int depth, int sum){
        //탈출
        if(depth==numbers.length){
            if(sum == target)answer++;
            return;
        }
        
        //계산
        //+일 경우 dfs
        dfs(numbers,target,depth+1,sum+numbers[depth]);
        //-일 경우 dfs
        dfs(numbers,target,depth+1,sum-numbers[depth]);
    }
}
