import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        String[] numberString = new String[numbers.length];
        
        
        //1) 예시는 valuef를 1씩 증가 시켜 다른 비트 갯수를 확인 후 가장 작은 수를 찾는다.
        //String에 진수변환 값을 입력
        for(int i=0;  i<numbers.length;i++){
            numberString[i]=String.valueOf(Long.toString(numbers[i],2));
            //System.out.println(numberString[i]);
        }
        
        //numbers 반복
        for(int i=0; i<numberString.length;i++){
            
            //짝수일 경우
            if(numbers[i]%2==0){
                answer[i] = Long.parseLong(numberString[i].substring(0,numberString[i].length()-1)+"1",2);
            }else{ //홀수일 경우
                //0이 존재하지 않는 경우
                if(!numberString[i].contains("0")){
                    answer[i] = Long.parseLong("10"+numberString[i].substring(1,numberString[i].length()),2);
                }else{//0이 존재하는 경우
                    //제일 작은 값을 표현하는 0을 1로변환후 그 인덱스의 뒷인덱스를 0으로 변환
                    int idx = numberString[i].lastIndexOf("0");
                    answer[i] = Long.parseLong(numberString[i].substring(0,idx) +"10"+numberString[i].substring(idx+2),2);
                }
                
                    
            }
           
                
                
        }
        
        
        return answer;
    }
    
    //2개의 비트 비교 메서드  return 2개 이하일 경우 true / 초과일 경우 false
    public boolean compareBinary(String value1, String value2){
        int count = 0;
        if(value1.length() != value2.length()){
            value1 = "0"+value1;
        }
       // System.out.println("v1 : "+value1 + ", v2 : "+value2);
        
        for(int i=0; i<value1.length();i++){
            if(value1.charAt(i)!= value2.charAt(i)){
                count++;
                if(count>2)return false;
            }
        }
        
        return true;
    }
}
