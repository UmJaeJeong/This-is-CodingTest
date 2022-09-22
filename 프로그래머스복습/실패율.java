import java.util.*;
class Solution {
    
    //전체 스테이지 수 N
    //현재 사용자가 멈춰있는 스테이지 번호가 담긴 배열 stages
    //스테이지에 도달했으나 아직  클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수 
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] checks = new double[N+2][2];
        
        for(int i=0; i<stages.length;i++){
            checks[stages[i]][1]++;
        }
        
        for(int i=1;i<=N;i++){
            checks[i][0] = i;
        }
        
        double totalPeople = stages.length;
        
        for(int i=1;i<=N;i++){
            double tmp = totalPeople-checks[i][1];

            checks[i][1]= checks[i][1]/totalPeople;
            totalPeople = tmp;
        }
        
        for(int i=1; i<N;i++){
            for(int j=i+1;j<=N;j++){
                if(checks[i][1]<checks[j][1]){
                    double[] tmp = new double[2];
                    tmp[0] = checks[i][0];
                    tmp[1] = checks[i][1];
                    checks[i][0] = checks[j][0];
                    checks[i][1] = checks[j][1];
                    checks[j][0] = tmp[0];
                    checks[j][1] = tmp[1];
                }else if(checks[i][1]==checks[j][1]){
                    if(checks[i][0]>checks[j][0]){
                    double[] tmp = new double[2];
                    tmp[0] = checks[i][0];
                    tmp[1] = checks[i][1];
                    checks[i][0] = checks[j][0];
                    checks[i][1] = checks[j][1];
                    checks[j][0] = tmp[0];
                    checks[j][1] = tmp[1];
                }
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            answer[i-1] = (int)checks[i][0];
        }
        
        
        return answer;
    }
    
}
