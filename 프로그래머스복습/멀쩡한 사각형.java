import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long w1 = w;
        long h1 = h;
        
        long max = Math.max(w,h);
        long min = Math.min(w,h);
        answer = w1*h1-(w1+h1-uclid(max,min));
        
        return answer;
    }
    
    public long uclid(long x, long y){
        if(y==0) return x;
        return uclid(y,x%y);
    }
}
