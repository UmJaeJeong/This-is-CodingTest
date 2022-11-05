//다시풀기
import java.util.*;

class Solution {
    int[] answer ={-1};
    int max = Integer.MIN_VALUE;
    int[] lion;
    boolean[] visited;
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(n,info);
        
        return answer;
    }
    
    public void dfs(int n, int[] info){
        //탈출
        if(n==0){
            int result = checkSum(info,lion);
            if(result>0){
                if(result>=max){
                    max = result;
                    answer = lion.clone();
                }
            }
            return;
        }
        
        for(int i=0; i<=10&& lion[i]<=info[i];i++){
            lion[i]++;
            dfs(n-1,info);
            lion[i]--;
        }
      
    }
    
    public int checkSum(int[] apeach, int[] info){
        int a_p = 0;
        int l_p = 0;
        for(int i=0; i<=10 ;i++){
            if(apeach[i]!=0 || lion[i]!=0){
                if(apeach[i]>=lion[i] ){
                    a_p+=10-i;
                }else if(lion[i]>apeach[i]){
                    l_p+=10-i;
                }
            }
            
        }
        return l_p-a_p;
    }
}
