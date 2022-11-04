import java.util.*;

class Solution {
  public String solution(String s) {
      String answer = "";
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      
      //s 문자열을 공백을 기준으로 배열로 분리
      String[] str = s.split(" ");
      //min값과 max값을 추출
      for(int i=0; i<str.length;i++){
          int value = Integer.parseInt(str[i]);
          min = Math.min(min,value);
          max = Math.max(max,value);
      }
      answer = String.valueOf(min)+" "+String.valueOf(max);
      //answer에 대입
      return answer;
  }
}
