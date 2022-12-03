class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int si = 0; //staions의  인덱스
        int position = 1; //아파트 1동부터 끝까지
        
        while(position<=n){
            if(si<stations.length&& position>= stations[si]-w){
                position = stations[si]+w+1; //기지국 오른쪽 끝
                si++;
            }else{
                answer++;
                position+=(w*2)+1;
            }
        }

        return answer;
    }
}
Footer
