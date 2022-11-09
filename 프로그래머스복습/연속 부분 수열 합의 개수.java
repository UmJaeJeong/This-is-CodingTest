//다시풀기
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        //중복값배제 Set사용
        HashSet<Integer> set = new HashSet<>();
        int[] update_e = new int[elements.length*2];
        
        for(int i=0; i<elements.length;i++){
            update_e[i] = elements[i];
            update_e[i+elements.length] = elements[i];
        }
        for(int i=0; i<elements.length;i++){
            int sum =0;
            for(int j=0; j<elements.length;j++){
   
                set.add(Arrays.stream(update_e,j,j+i).sum());
               
            }
        }
        
        return set.size();
    }
}
