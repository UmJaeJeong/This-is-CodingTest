//다시풀기
//dfs를 못하는경우 
//이분탐색이나 DP를 생각
class Solution {
    public int solution(int n) {
        int[] answer = new int[60001];
        answer[1] = 1;
        answer[2] = 2;
        for(int i=3; i<=n;i++ ){
            answer[i] = (answer[i-1]+answer[i-2])%1000000007;
        }
        return answer[n];
    }
}
