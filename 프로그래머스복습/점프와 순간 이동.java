import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int sub =1;
        while(n!=0){
            if(n%2==1){
                n-=1;
                ans+=1;
            }
            n=n/2;
        }
        return ans;
    }
}
