import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //1. Map에 nums를 넣는다 key(포켓몬) value(수)
        Map<Integer, Integer> map = new  HashMap<>();
        
        for(int i=0; i<nums.length;i++){
           //2. Map에 nums를 넣는다 key(포켓몬) value(수) ,Map에 nums를 넣기전에 포켓몬이 이미 존재하는지 확인한다.
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            
        }
        
        
        //3. Map의 총수이므로,
        // 1)nums의 총 수의 /2보다 작다면 Map에 들어있는 포켓몬의 종류를 선택
        // 2)nums의 총수의/2보다 크다면 nums/2만큼의 포켓몬을 선택
        return map.size()>=nums.length/2 ? nums.length/2 : map.size();
    }
}
