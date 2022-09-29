class Solution {
    //가로-2 * 세로-2 - 노란색
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1;i<brown;i++){
            for(int j=1;j<brown;j++){
                if(i*j>brown+yellow) continue;
                if(check(i,j,yellow)){
                    answer[0]=i;answer[1]=j;
                }
            }
        }
        return answer;
    }
    
   public boolean check(int width, int height, int y){
        if((width-2)*(height-2) == y)return true;
        return false;
    }
}
