import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        recrusive("",numbers);
        
        
        return set.size();
    }
    
    public void recrusive(String s, String others){
        if(!s.isEmpty()){
            int n = Integer.parseInt(s);
            if(isPirme(n)) set.add(n);
        }
    
        for(int i=0; i<others.length();i++){
            recrusive(s+others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
    
    }
    
    //에라토스테네스의 체
    public boolean isPirme(int num){
        if(num ==0 || num ==1) return false;
        int n = (int)Math.sqrt(num);
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}
