class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max1 = 0;
        int max2 = 0;
        
        for(int i=0; i<sizes.length;i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            if(width>height){
                max1 = Math.max(max1,width);
                max2 = Math.max(max2,height);
            }else{
                max1 = Math.max(max1,height);
                max2 = Math.max(max2,width);
            }
            
        }
        return max1*max2;
    }
}
