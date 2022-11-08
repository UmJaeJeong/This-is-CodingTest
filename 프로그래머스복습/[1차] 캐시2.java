import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return cities.length*5;
        
        Queue<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length;i++){
            String city = cities[i].toUpperCase();
            
            if(cache.remove(city)){
                answer++;
                cache.add(city);
            }else{
                answer+=5;
                if(cache.size()>=cacheSize){
                    cache.poll();
                }
                cache.add(city);
            }
        }
        return answer;
    }
}
