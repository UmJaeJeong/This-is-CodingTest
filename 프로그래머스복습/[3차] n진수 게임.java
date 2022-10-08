import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        //자기가 불러야하는 값이 포함된 문자의 최소 길이 
        int sumLength = m*t;
    
        //문자의 최대길이
        int totalLength = 0;
        
        String totalWord = "";
        int i=0;
        while(sumLength>totalLength){
            String convertNumber = Integer.toString(i++, n);
            totalLength+=convertNumber.length();
            totalWord+=convertNumber.toUpperCase();
        }
        i=0;
        System.out.println(totalWord);
        ArrayList<String> list = new ArrayList<>();
        while(i<totalWord.length()/m){
            int idx = (i*m)+p-1;
            i++;
            answer+=String.valueOf(totalWord.charAt(idx));     
        }
        
       
       
        return answer;
    }
}
