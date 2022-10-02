import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        boolean check = false;
        
        for(String s : words){
            if(target.equals(s)){
                check = true;
                break;
            } 
        }
        if(!check) return 0;
        
        dfs(begin,target,words,0,0);
        return min;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt, int idx){
        System.out.println(begin);
        if(begin.equals(target)){
            
            min = Math.min(min,cnt);
            
            return;
        }
        
        for(int i=0; i<words.length;i++){
          
            if(!visited[i] && checkConvert(begin,words[i])){
                
                visited[i] = true;
                begin = words[i];
                dfs(begin,target,words,cnt+1,i);
                
            }
        }
    }
    public boolean checkConvert(String orgin, String temp){
        int correctCnt = 0;
        
        for(int  i=0; i<orgin.length();i++){
            if(orgin.charAt(i) == temp.charAt(i)) correctCnt++;
        }
        
        return orgin.length()-correctCnt==1?true:false;
    }
}
